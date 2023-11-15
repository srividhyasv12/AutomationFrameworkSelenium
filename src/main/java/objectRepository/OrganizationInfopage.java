package objectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {
//Declaration
	@FindBy(xpath= "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
//initialization	
	public OrganizationInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Bussiness libraries
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String getOrganizationHeader()
	{
		return OrgHeaderText.getText();
	}
	
	

	
}
