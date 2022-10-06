package Com.Salesforce.test.pages.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Salesforce.test.pages.base.BasePage;


public class ForgotpwdPage extends BasePage{
		
		@FindBy(xpath="//input[@id='un'] ")WebElement UId;
		@FindBy(xpath="//input[@id='continue']")WebElement continuebutton;
		@FindBy(xpath="//h1[@id='header'] ") WebElement forgorgotpwdmsg;
	     public ForgotpwdPage(WebDriver driver) {
			
			super(driver);
		}
		
      public void enterUserName(String usrname) {
    	  waitUntilVisible(UId,"user name field");
	 		enterText(UId, usrname, "username field");
	 	}    
		
      public void clickcontinuebutton() {
  		  clickElement(continuebutton,"continue button");
  	}
      public void forgotpwd(String username) {
    	 
    	  enterUserName(username);
    	  clickcontinuebutton();
      }
      public String gettextFromforgotpwdpage() {
  		String text=readText(forgorgotpwdmsg, "text form field");
  		captureWebElementScreenshot(forgorgotpwdmsg, "forgorgotpwdmsg");
  		
  		return text;
  	}

}
