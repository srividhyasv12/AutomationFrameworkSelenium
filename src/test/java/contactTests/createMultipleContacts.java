package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.loginpage;

public class createMultipleContacts {
	
	ExcelFileUtility eUtil =new  ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleContact(String LastName) throws InterruptedException, IOException
	{
		javaUtility jutil = new javaUtility();
		WebDriver driver = null;

		// step1:read all the the required data
		/* common Data */
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");


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
		

		//Step 3:Log into Application
		loginpage lp = new loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 4:Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//Step 5:Click On Create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		
		//Step 6: Create new contact 
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LastName);
		
		//Step 7:Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		if(contactheader.contains(LastName))
		{
			System.out.println(contactheader);
		System.out.println("pass");	
		}
		else {
			System.out.println("fail");
		}
		
		//Step 8:logout
	    hp.logoutOfApp(driver);

		//Step 9: Close The Browser
		driver.quit();
		
			
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	return eUtil.readMultipledataFromExcel("createMultipleContacts");	
	}
}
