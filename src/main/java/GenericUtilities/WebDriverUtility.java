package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of all generic methods related to webdriver actions
 * 
 * @author srividhya
 *
 */
public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximixeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * this method will minimize the window
	 * 
	 * @param driver
	 * @param time
	 */

	 public void minimizeWindow(WebDriver driver) {
		 driver.manage().window().minimize();
		 }
	/**
	 * this method will wit for 10 seconds for the webpage to get loaded
	 */
	public void waitforPageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
/**
 * this method will wait for 10 seconds for the element to be visible
 * @param driver
 * @param element
 * @param time
 */
	public void waitElementtoBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait for 10 seconds for the element to be clickable
	 * @param driver
	 * @param element
	 * @param time
	 */
	public void explicitWAit(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
}
	/**
	 * this method will handle dropdown by index
	 * @param element
	 * @param index 
	 */
	public void handleDropDown(WebElement element, int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by value
	 * @param element
	 * @param index 
	 */
	public void handleDropDown(WebElement element,String value) {
	Select sel = new Select(element);
	sel.selectByValue(value);
	}	
	/**
	 * this method will handle dropdown by visibleTEXT
	 * @param element
	 * @param text 
	 * @param index 
	 */
	public void handleDropdown(WebElement element, String text) 
	{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
	}
	/**
	 * this method will perform mouse hovering
	 * 
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * this method will perform double click on web element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element){
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();		
}
	/**
	 * this method will perform rightclick on web element
	 */
	public void rightclick(WebDriver driver,WebElement element){
		Actions act = new Actions(driver);
		act.contextClick(element).perform();		
}

	/**
	 * this method will perform drag and drop the src element to target element
	 * @param targetele 
	 * @param srcele 
	 */
	public void dragandDropAction(WebDriver driver, WebElement targetele, WebElement srcele){
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, targetele).perform();		
}	
	/**
	 * this method will perform click an hold the element
	 * @param element 
	 * @param targetele 
	 * @param srcele 
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element){
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();		
}
/**
 * this method will scroll down for 500 units
 */
public void scrollDownAction(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)","");
	
}
/**
 * this method will scroll up for 500 units
 * @param driver
 */
public void scrollUPAction(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,-500)","");
	
}
/**
 * this method will scroll right for 500 units
 * @param driver
 */
public void scrollRightAction(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(500,0)","");
	
}
/**
 * this method will scroll left for 500 units
 * @param driver
 */
public void scrollLeftAction(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(-500,0)","");
	
}
/**
 * this method will accept the alert popup
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * this method willaccept the alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * this method will capture the alert text and return to the caller
 * @param driver
 * @return 
 */
public String getAlertText(WebDriver driver) {
	String text = driver.switchTo().alert().getText();
	return text;
}
/**
 * this method will switch to frame based on index//wed class 11/10/23
 * @param driver
 * @param index
 */
public void switchToFrameIndex(WebDriver driver, String index) {
	driver.switchTo().frame(index);
}
/**
 * this method will switch to frame based on NameorId
 * @param driver
 * @param nameorID 
 * @param index
 */
public void switchToFrameName(WebDriver driver, String nameorID) {
	driver.switchTo().frame(nameorID);
}
/**
 * this method will switch to frame based on webelement
 * @param driver
 * @param nameorID 
 * @param index
 */
public void switchToFrameWEBeLe(WebDriver driver, String element) {
	driver.switchTo().frame(element);
}
/**
 * this methos will switch the windows based on partial with title
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver, String partialWindowTitle) {
//step1:capture all the window ID'S
	Set<String> allWindowIDS = driver.getWindowHandles();//main/child/child/child

	//step 2: navigate through each window ID	
	for(String windowid:allWindowIDS) {
		
		//step3:switch to each window and capture the title
		String actTiltle = driver.switchTo().window(windowid).getTitle();
		
		//step4: compare the actual title with expected partial window title
		if(actTiltle.contains(partialWindowTitle)) 
		{
			break;
		}
			
	}
}
/**
 * this method will screenshot and store in requried folder
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException  {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
	Files.copy(src, dst);//crct
	//FileUtils.copyDirectory(src, dst);
	return dst.getAbsolutePath();//complete path of screenshot==>extend reports
	
}



}