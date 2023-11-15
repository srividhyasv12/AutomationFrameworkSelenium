package Data_Driven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScenarioWithDDT {
public static void main(String[] args) throws IOException, Throwable {
	//step1:read all the the required data
	/*common Data*/
	FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fisp);
String URL = p.getProperty("url");
String BROWSER = p.getProperty("browser");
String USERNAME = p.getProperty("username");
String PASSWORD = p.getProperty("password");

/*test Data*/
FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb =  WorkbookFactory.create(fise);
String LastName = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
WebDriver driver=null;



//step2:launch the browser-Polymorphism---run time POlymorphism
if(BROWSER.equalsIgnoreCase("Chrome")) {
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();	
}
else if(BROWSER.equalsIgnoreCase("Firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver =new FirefoxDriver();	
}
else if(BROWSER.equalsIgnoreCase("Edge"))
{
	WebDriverManager.edgedriver().setup();
	driver =new EdgeDriver();	
}
else 
{
	System.out.println("invalid browse name");
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.get(URL);

//step 3:Login to application with valid credentials

driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);//username
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);//password
driver.findElement(By.xpath("//input[@type='submit']")).click();//login click

//step 4:NAVIGATE TO CONTACT LINK
driver.findElement(By.xpath("//a[text()='Contacts']")).click();//contactsclick	

//step 5:click on create  contact look up image
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

//step 6:Create Contact with Mandatory fields
//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sri");
driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);

//step 7:Save
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();//save

//step8:validate
String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(contactheader.contains(LastName))
{
	System.out.println(contactheader);
	System.out.println("pass");
}
else
{
	System.out.println("Fail");
}Thread.sleep(3000);


//step 9:logout
WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act = new Actions(driver);
act.moveToElement(ele).perform();
Thread.sleep(3000);
driver.findElement(By.linkText("Sign Out")).click();
System.out.println("logout is successfull");























}

}

