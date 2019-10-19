package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForElementPresent(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public String waitForPageTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public void waitForElementClickable(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element=null;
		waitForElementPresent(locator);
		try
		{
			element=  driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Exception while getting the element..."+locator);
		}
		return element;
	}
	
	public void doClick(By locator)
	{
		try 
		{
			getElement(locator).click();
		}
		catch(Exception e)
		{
			System.out.println("Exception while clicking the element..."+locator);
		}
	}
	
	public void doClickByActions(By locator)
	{
		Actions action=new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}
	public void doSendKeysByAction(By locator, String text)
	{
		Actions action=new Actions(driver);
		action.sendKeys(getElement(locator), text).build().perform();
	}
	
	public void doSendKeys(By locator, String text)
	{
		try
		{
			getElement(locator).clear();
			getElement(locator).sendKeys(text);
		}
		catch(Exception e)
		{
			System.out.println("Exception while sending keys to the element..."+locator);
		}
	}
	
	public String doGetText(By locator)
	{
		String text=null;
		try
		{
			text=getElement(locator).getText();
		}
		catch(Exception e)
		{
			System.out.println("Exception while getting text from the element..."+locator);
		}
		return text;
	}
	
	public boolean isElementDisplayed(By locator)
	{
		boolean flag=false;
		try
		{
			flag=getElement(locator).isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("Exception while getting the lement isDisplayed..."+locator);
		}
		return flag;
	}
	
		
	
	
	
	
	

}
