package GenericUtilities;
/**
 * This class consist of basic configuration annotation of testNG
 * @author rajes
 *
 */

import java.io.IOException;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.loginpage;

public class BaseClass {
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public javaUtility jUtil = new javaUtility();
	public WebDriver driver = null;

	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)   //(groups = "SmokeSuite")//exclude in suite
	public void bsConfig()
	{
		System.out.println("======= DB Connection Successfull======");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
    public void bcconfig(/*String BROWSER*/) throws IOException
	{
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();	
		System.out.println(BROWSER+"===Browser Launched");
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver =new FirefoxDriver();
		System.out.println(BROWSER+"===Browser Launched");
	}
	else if(BROWSER.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		System.out.println(BROWSER+"===Browser Launched===");
	}
	else 
	{
		System.out.println("invalid browse name");
	}
	
	sdriver=driver;///used in listeners
	wUtil.maximixeWindow(driver);
	wUtil.waitforPageload(driver);
	driver.get(URL);
	
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		loginpage lp = new loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==== Login Successfull====");
				
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("==== Logout Successfull===");
		
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
	driver.quit();	
	System.out.println("======= Browser closed Successfull======");
	}

	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("=======Db close Successfull======");	
	}

	
	
	

}
