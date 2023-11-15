package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {//Rule 1:
	
//Declaration
	@FindBy(name= "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name= "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
//Declaration
	public loginpage(WebDriver driver) {
			
	PageFactory.initElements(driver, this);
	}


//Utiliztion
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//bussiness library==>generic method using the webelement in current page only
	 /**
	  * This Method Will Login To Application
	  * @param USERNAME
	  * @param PASSWORD
	  */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
}
