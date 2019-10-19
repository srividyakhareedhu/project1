package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.Constants;
import util.ElementActions;

public class ContactsPage {
	WebDriver driver;
	Actions action;
	ElementActions eleActions;

	//Objects
	By contactsPageHeader=By.xpath("//*[@data-key='genericTypes.capitalized.CONTACT']");
	By createContactOnPage=By.xpath("//span[text()='Create contact']");
	By createContactOnForm=By.xpath("//div[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By fn=By.xpath("//input[@data-field='firstname']");
	By ln=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	
	//Constructor
	public ContactsPage(WebDriver driver) 
	{
		this.driver=driver;
		action=new Actions(driver);
		eleActions=new ElementActions(driver);
	}
	
	//Methods
	public String getContactsPageTitle()
	{
		return eleActions.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}
	
	public boolean isContactsPageHeaderDisplayed()
	{
		return eleActions.isElementDisplayed(contactsPageHeader);
	}
	
	public String getContactsPageHeader()
	{
		return eleActions.doGetText(contactsPageHeader);
	}

	public boolean isCreateButtonDisplayed()
	{
		return eleActions.isElementDisplayed(createContactOnPage);
	}
	
	public void createContact(String emailId, String fName, String lName, String title)
	{
		eleActions.waitForElementClickable(createContactOnPage);
		eleActions.doClickByActions(createContactOnPage);
		eleActions.doSendKeys(email, emailId);
		eleActions.doSendKeys(fn, fName);
		eleActions.doSendKeys(ln, lName);
		eleActions.waitForElementClickable(jobTitle);
		eleActions.doSendKeysByAction(jobTitle, title);
		eleActions.doClickByActions(createContactOnForm);
	}
	
	public void test()
	{
		System.out.println("GIT update test method");
	}
}
