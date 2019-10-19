package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import util.Constants;
import util.ElementActions;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementActions eleActions;
	
	//Object Repository
	By emailId=By.id("username");
	By password=By.id("password");
	By showPswd=By.xpath("//span[contains(text(),'Show Password')]");
	By loginBtn=By.id("loginBtn");
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleActions=new ElementActions(driver);
	}
	
	//Methods
	public String getLoginPageTitle()
	{
		 return eleActions.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isShowPasswordDisplayed()
	{
		 return eleActions.isElementDisplayed(showPswd);
	}
	
	public HomePage doLogin(String user, String pwd)
	{
		eleActions.getElement(emailId).sendKeys(user);
		eleActions.getElement(password).sendKeys(pwd);
		eleActions.getElement(loginBtn).click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new HomePage(driver);
	}
}
