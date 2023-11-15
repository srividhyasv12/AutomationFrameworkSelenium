package Vtiger;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario1 {
	public static void main(String[] args) throws Throwable {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
				driver.manage().window().maximize();
		

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
//step 1:LAUNCH BROWSER
				driver.get("http://localhost:8888/");
//step 2:Login to application with valid credentials
				
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");//username
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");//password
				driver.findElement(By.xpath("//input[@type='submit']")).click();//login click
				
//step 3:NAVIGATE TO CONTACT LINK
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();//contactsclick	
				
//step 4:click on create  contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
//step 5:Create Contact with Mandatory fields
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sri");
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("vidu");
//step 6:Save 				
				driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();//save
//step7:validate
				String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(contactheader.contains("vidu"))
				{
					System.out.println(contactheader);
					System.out.println("pass");
				}
				else
				{
					System.out.println("Fail");
				}Thread.sleep(3000);
//step 8:logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout is successfull");
			
	}

				
	}


