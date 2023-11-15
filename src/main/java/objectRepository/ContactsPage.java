package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//Declaration
	@FindBy(xpath ="//img[@title='Create Contact...']")
	private WebElement createContatLookUpImage;
	
//initialization
	public ContactsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

//utilizations

	public WebElement getCreateContatLookUpImage() {
		return createContatLookUpImage;
	}
	
	//bussiness library
	/**
	 * this method will create create contact lookup image
	 */
	public void clickOnCreateContactLookUpImage()
	{
		createContatLookUpImage.click();
	}
}
