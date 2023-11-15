package TestNg;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;
import com.github.dockerjava.api.model.ContainerNetworkSettings;

import GenericUtilities.BaseClass;
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


@Listeners(GenericUtilities.ListenersImplementation.class)
public class CreateContactTestBaseClassTest extends BaseClass{
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createNewContactTest() throws IOException, InterruptedException//Test Method

		{

//step1:Read All  theData required
		/* test Data */
		String LastName = eUtil.readDataFromExcel("contacts", 1, 2);
		

		//Step 4:Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//Step 5:Click On Create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		//Assert.fail();
		
		//Step 6: Create new contact 
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LastName);
		
		//Step 7:Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		Assert.assertTrue(contactheader.contains(LastName) );
		System.out.println(contactheader);
		
		
	}
	
	@Test
	public  void demo()
	{
	System.out.println("demo");	
	}
	}

