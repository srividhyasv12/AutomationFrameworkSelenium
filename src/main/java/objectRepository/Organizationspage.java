package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
//Declaration
	@FindBy(xpath= "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
//initialization
	public  Organizationspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
//declaration
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	
	//Bussiness libraries
	/**
	 * This method will click on crete org lookup menu
	 */
	public void clickOnCreateOrgLookUpMenu()
	{
		CreateOrgLookUpImg.click();	
	}
	
	
}
