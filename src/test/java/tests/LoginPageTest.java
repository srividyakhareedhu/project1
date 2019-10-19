package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import util.Constants;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage base;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() 
	{
		base=new BasePage();
		prop = base.init_properties();
		driver=base.init_driver(prop);
		loginPage=new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void showPswdDispTest()
	{
		Assert.assertTrue(loginPage.isShowPasswordDisplayed());
	}
	
	@Test(priority=3)
	public void doLoginTest()
	{
		homePage=loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
