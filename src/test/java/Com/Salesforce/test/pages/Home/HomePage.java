package Com.Salesforce.test.pages.Home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Salesforce.test.pages.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//li[@id='home_Tab']") WebElement Hometab;
	@FindBy(css="#userNavLabel") WebElement UserMenu;
	@FindBy(linkText="Logout") WebElement Logout;
	@FindBy(xpath="/html/head/title") WebElement logouttitle;
	@FindBy(id="tryLexDialog") WebElement modalContainer;
	@FindBy(id="tryLexDialogX") WebElement dialogclosebutton;
	
	
    public HomePage(WebDriver driver) {
		
		super(driver);
	}
	public void clicklogout() {
		clickElement(Logout,"Logout");
	}
	public void clickHometab() {
		clickElement(Hometab,"Hometab");
	}
	public void closedialog() {
		waitUntilVisible(modalContainer,"modalContainer");
		clickElement(dialogclosebutton,"dialogclosebutton");
	}
	public void clickusermenu() {
		waitUntilVisible(UserMenu,"UserMenu");
		clickElement(UserMenu,"UserMenu");
	}
	public void logout() {
		clickusermenu();
		//closedialog();
		clicklogout();
	}
    public String GetTextFromHometabElement() {
		String text=readText(Hometab, "text form field");
		captureWebElementScreenshot(Hometab, "Homelogintext");
		
		return text;
	}
    public String GetTextlogouttitleElement() {
    	waitUntilVisible(logouttitle,"logouttitle");
    	String text=readText(logouttitle, "text form field");
		captureWebElementScreenshot(logouttitle, "logouttitle");
		
		return text;
		 
	}

}
