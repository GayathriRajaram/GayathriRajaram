package Com.Salesforce.test.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Salesforce.test.basetest.BaseTest;
import Com.Salesforce.test.utility.CommonUtilities;
import Com.Salesforce.test.pages.Home.HomePage;
import Com.Salesforce.test.pages.login.ForgotpwdPage;
import Com.Salesforce.test.pages.login.LoginPage;
import Com.Salesforce.test.utility.GenerateReports;

public class AutomationScripts extends BaseTest {
	
	@Test
	public static void logoutFromSalesForce09() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String username = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		LoginPage login=new LoginPage(driver);
		login.login(username, passwrd);
		ImplicitWaitmethod();
		HomePage homepage=new  HomePage(driver);
		homepage.logout();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("expectedlogoutmsg", testverificationPropertiesFile);
		ImplicitWaitmethod();
		String actual=homepage.getcurrenturl();
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());
		
		
	} 
	@Test
	public static void loginwithvalidCredentials02() throws Exception{
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String username = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		LoginPage login=new LoginPage(driver);
		login.login(username, passwrd);
		HomePage homepage=new  HomePage(driver);
		ImplicitWaitmethod();
		String actual=homepage.GetTextFromHometabElement();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("expectedloginmsg", testverificationPropertiesFile);
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());
	}
	@Test
	public static void loginErrorMessage01() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String username = CU.getApplicationProperty("username", applicationPropertiesFile);
		String password=CU.getApplicationProperty("password", applicationPropertiesFile);
		LoginPage login=new LoginPage(driver);
		login.loginwithnopwd(username, password);
		String actual=login.gettextFromloginpage();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("expectedloginerrormsg", testverificationPropertiesFile);		
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());
	}
	@Test
	public static void checkRememberMe03() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		LoginPage login = new LoginPage(driver);
		login.loginwithremeberme(UserName, passwrd);
		HomePage homepage=new  HomePage(driver);
		homepage.logout();
		String actual=login.gettextFromID();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("ID", testverificationPropertiesFile);
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());
	}
	@Test
	public static void forgotPassword4A() {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
		ForgotpwdPage forgotobj = new ForgotpwdPage(driver);
		LoginPage login =new LoginPage(driver);
		login.clickforgotpwd();
		forgotobj.forgotpwd(UserName);
		String actual=forgotobj.gettextFromforgotpwdpage();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("expectedforgotmsg", testverificationPropertiesFile);		
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());	}
	@Test
	public static void wrongCredential4B() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("Wusername", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("Wpassword", applicationPropertiesFile);
		LoginPage login =new LoginPage(driver);
		login.login(UserName, passwrd);
		String actual=login.gettextFromloginpage();
		Properties testverificationPropertiesFile = CU.loadFile("testverificationproperties");
		String expected=CU.getApplicationProperty("expectedloginerrormsg1", testverificationPropertiesFile);		
		Assert.assertEquals(actual,expected);
		report.logTestinfo("testscript execution completd");
		report.logTestinfo(getPageTitle());
		
	}
}
