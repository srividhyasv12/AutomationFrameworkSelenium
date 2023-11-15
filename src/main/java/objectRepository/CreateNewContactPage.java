package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	//declaration
@FindBy(name= "lastname")
private WebElement lastNameEdt;

@FindBy(xpath ="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn ;

@FindBy(xpath= "(//img[@title='Select'])[1]")
private WebElement OrgLookUpImg;

@FindBy(name="search_text")
private WebElement OrgsearchEdt;

@FindBy(name="search")
private WebElement OrgSearchBtn;

//initialization
public CreateNewContactPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//declaration
public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

public WebElement getOrgLookUpMenu() {
	return OrgLookUpImg;
}

public WebElement getOrgsearchEdt() {
	return OrgsearchEdt;
}

public WebElement getOrgSearchBtn() {
	return OrgSearchBtn;
}

//Bussiness Libraries
/**
 * this method will
 * @param LASTNAME
 */
public void createNewContact(String LASTNAME)
{
	lastNameEdt.sendKeys(LASTNAME);
	 SaveBtn.click();
}
/**
 * This method will crete contact by choosing the organization method
 * @param driver
 * @param ORGNAME
 * @param LASTNAME
 */
public void createNewContact(WebDriver driver,String ORGNAME, String LASTNAME)
 
{
	lastNameEdt.sendKeys(LASTNAME);
	OrgLookUpImg.click();
	switchToWindow(driver, "Accounts");
	OrgsearchEdt.sendKeys(ORGNAME);
	OrgSearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	switchToWindow(driver, "Contacts");
	SaveBtn.click();
}
}
