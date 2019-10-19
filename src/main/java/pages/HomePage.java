package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import util.Constants;
import util.ElementActions;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ContactsPage contactsPage;
	ElementActions eleActions;
	
	//Object Repository
	By accName = By.xpath("//*[@data-key= 'getting-started-ui.header.welcomeBack']/span[2]");
	By pageHeader = By.xpath("//*[@data-key= 'getting-started-ui.appHeaderTitle']");
	By contactsMainMenu=By.xpath("//a[@id='nav-primary-contacts-branch']");
	By contactsSubMenu=By.xpath("//a[@id='nav-secondary-contacts']");
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		eleActions=new ElementActions(driver);
	}
	
	//methods
	public String getHomePageTitle()
	{
		return eleActions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public boolean isHomePageHeaderDisplayed()
	{
		return eleActions.isElementDisplayed(pageHeader);
	}
	
	public String getHomePageHeader()
	{
		return eleActions.doGetText(pageHeader);
	}
	
	public boolean isAccHolderNameVisible()
	{
		return eleActions.isElementDisplayed(accName);
	}
	public String getAccountHolderName()
	{
		return eleActions.doGetText(accName);
	}
	
	public ContactsPage goToContactsPage()
	{
		clickOnContactsMenu();
		eleActions.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
		return new ContactsPage(driver);
	}
	
	private void clickOnContactsMenu()
	{
		eleActions.doClick(contactsMainMenu);
		eleActions.waitForElementPresent(contactsSubMenu);
		eleActions.doClick(contactsSubMenu);
	}
}
