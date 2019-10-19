package tests;

import static org.testng.Assert.assertEquals;

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

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage base;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		base=new BasePage();
		prop=base.init_properties();
		driver=base.init_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void homePageHeaderTest()
	{
		Assert.assertTrue(homePage.isHomePageHeaderDisplayed());
		String actualHomePageHeader=homePage.getHomePageHeader();
		System.out.println("Actual Header: "+actualHomePageHeader);
		Assert.assertEquals(actualHomePageHeader, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void acctHolderNameTest()
	{
		Assert.assertTrue(homePage.isAccHolderNameVisible());
		String actualName=homePage.getAccountHolderName();
		System.out.println("Actual Name: "+actualName);
		Assert.assertEquals(actualName, prop.getProperty("accountHolderName"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
