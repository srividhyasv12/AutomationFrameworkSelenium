package TestNg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
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

public class CreatecontactWithOrgTestBaseClassTest extends BaseClass {
	
@Test(groups = "RegressionSuite")
public void createNewContactWithOrgTest() throws IOException, InterruptedException

{
	

		
		/*test Data*/
        String LastName = eUtil.readDataFromExcel("contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("contacts", 4, 3)+jUtil.getRandomNumber();


		
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
	 Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		System.out.println("organization created");	
		
		
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
		 Assert.assertTrue(contactheader.contains(LastName));
			System.out.println(contactheader);
	
		
		
		
}
}
