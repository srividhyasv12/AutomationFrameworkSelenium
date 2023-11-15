   package Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario5 {
	public static void main(String[] args) throws Throwable {

		//WebDriverManager.edgedriver().setup();
	//	WebDriver driver = new EdgeDriver();
		
			//	driver.manage().window().maximize();
		

//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//create object of all utilities
	ExcelFileUtility eUtil =new  ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	javaUtility  jutil = new javaUtility();
	WebDriver driver = null;
	
	//step1:read all the the required data
		/*common Data*/
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD= pUtil.readDataFromPropertyFile("password");

	
	/*test Data*/

	String LASTNAME = eUtil.readDataFromExcel("contacts", 4, 2);
	String ORGNAME= eUtil.readDataFromExcel("contacts", 4, 3)+jutil.getRandomNumber();


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
	wUtil.maximixeWindow(driver);
	wUtil.waitforPageload(driver);
	driver.get(URL);

	//step 3:Login to application with valid credentials

	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);//username
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);//password
	driver.findElement(By.xpath("//input[@type='submit']")).click();//login click
	
	//step4:navigate to organzations
	driver.findElement(By.linkText("Organizations")).click();
	
	//step 5: click on create organization lookup image
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step 6:create organization with mandatory fields
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	
	//step 7:save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//step 8:validate
	String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgHeader.contains(ORGNAME)) {
		System.out.println(orgHeader); 
		System.out.println("organization created");
	}
	else
	{
		System.out.println("FAILED");
	}
	
//step 9:NAVIGATE TO CONTACT LINK
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();//contactsclick	
				
//step 10:click on create  contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
//step 11:Create Contact with Mandatory fields
				//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sri");
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
//step 12:click on organization lookup menu
				driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
//step:13:switch the control to child window
			wUtil.switchToWindow(driver, "Accounts");
			System.out.println("switched to child window");
				
//step14:search for oranization				 
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search_text")).click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();

//step15:Switch the control back to the parent
		wUtil.switchToWindow(driver, "Contacts");
	    System.out.println("switched back to parent");
			 
//step16:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
//step17:validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
//step 14:logout
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, ele);
			Thread.sleep(3000);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("logout is successfull");
					
	}

	
}
