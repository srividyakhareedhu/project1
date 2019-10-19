package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.Constants;
import util.ExcelUtil;

public class ContactsPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage base;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp()
	{
		base=new BasePage();
		prop=base.init_properties();
		driver=base.init_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
		contactsPage=homePage.goToContactsPage();
		
	}
	@Test(priority=1, enabled=false)
	public void contactsPageTitleTest()
	{
		String actualTitle=contactsPage.getContactsPageTitle();
		System.out.println("actualTitle: "+actualTitle);
		Assert.assertEquals(actualTitle, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@Test(priority=2, enabled=false)
	public void contactsPageHeaderTest()
	{
		Assert.assertTrue(contactsPage.isContactsPageHeaderDisplayed());
		String actualHeader=contactsPage.getContactsPageHeader();
		System.out.println("actualHeader: "+actualHeader);
		Assert.assertEquals(actualHeader, Constants.CONTACTS_PAGE_HEADER);
	}
	
	@Test(priority=3, dataProvider="getContactsData")
	public void createContactTest(String emailId, String firstName, String lastName, String jobTitle)
	{
		contactsPage.createContact(emailId, firstName, lastName, jobTitle);
	}
	
	@DataProvider
	public Object[][] getContactsData()
	{
		Object contacts[][]=ExcelUtil.getDataFromSheet("contacts");
		return contacts;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
