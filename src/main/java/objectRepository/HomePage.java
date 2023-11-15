package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//Declaretion-webelements-dropdowns,windows,frames,moveshovering,
    @FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
    
    @FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
    
    @FindBy(linkText = "Products")
	private WebElement productsLnk;
    
    @FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
    
    @FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
    
    
    //initialization
    public HomePage(WebDriver driver) 
    {
    	PageFactory.initElements( driver,this);
    }

    //utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getProductsImg() {
		return productsLnk;
	}



	public WebElement getAdministatorLnk() {
		return administatorImg;
	}


	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
    
	//bussinesslibraries
	/**
	 * this method will click on organisation link
	 * 
	 */
	  public void clickOnOrgLnk()
	    {
	    	organizationLnk.click();
	    }
    
	  public void clickOnContactsLnk()
	    {
		  contactsLnk.click();
	    }
    /**
     * this method will logout of application
     * @param driver
     * @throws InterruptedException 
     * @throws Throwable
     */
	  public void logoutOfApp(WebDriver driver) throws InterruptedException 
	    {
		  mouseHoverAction(driver,administatorImg);
		  Thread.sleep(3000);
		  signOutLnk.click();
	    }
    
	
}
