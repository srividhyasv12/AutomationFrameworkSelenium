package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationpage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name="accounttype")
	private WebElement TypeDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationpage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	//Utilization

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDw() {
		return IndustryDropDwn;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Busssiness library
	/**
	 * This method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create new organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRYNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn,INDUSTRYNAME);
		SaveBtn.click();
	}
	
	
	
}
