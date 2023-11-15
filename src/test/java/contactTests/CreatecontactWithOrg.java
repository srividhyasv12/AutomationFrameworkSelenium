package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationpage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfopage;
import objectRepository.Organizationspage;
import objectRepository.loginpage;

public class CreatecontactWithOrg {
public static void main(String[] args) throws IOException, InterruptedException {
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
        String LastName = eUtil.readDataFromExcel("contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("contacts", 4, 3)+jutil.getRandomNumber();


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
		
		//Step 4:Navigate to org Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		
		//Step 5:Click On Create org Look Up Image
		Organizationspage op = new Organizationspage(driver);
		op.clickOnCreateOrgLookUpMenu();
		
		//Step 6: Create new org
		CreateNewOrganizationpage cnop = new CreateNewOrganizationpage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 7:Validate for org
		OrganizationInfopage oip = new OrganizationInfopage(driver);
		String orgHeader = oip.getOrganizationHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
		System.out.println("Pass");	
		}
		else {
			System.out.println("Fail");
			
		}
		
		//step 8:navigate to contacts
		hp.clickOnContactsLnk();
		
		//step 9:click on create contact look up image
		ContactsPage cP = new ContactsPage(driver);
		cP.clickOnCreateContactLookUpImage();
		
		//step 10:create contact with organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, ORGNAME, LastName);
		
		//Step 11:Validate
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
		
		//Step 12:logout
	    hp.logoutOfApp(driver);

		//Step 13: Close The Browser
		driver.quit();
		
		
		
		
}
}
