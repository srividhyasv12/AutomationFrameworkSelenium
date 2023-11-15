package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//declaration
@FindBy(xpath= "//span[@class='dvHeaderText']")
private WebElement contactHeaderText;

//initialization
public ContactInfoPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//utilization
public WebElement getContactHeaderText() {
	return contactHeaderText;
}
//bussiness library
/**
 * this method will capture the header text and return it to caller
 * @return
 */
public String getContactHeader()
{
	return contactHeaderText.getText();
}

}
