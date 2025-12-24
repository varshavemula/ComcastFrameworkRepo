package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getParentWindowID(WebDriver driver)
	{
		String ID=driver.getWindowHandle();
		return ID;
	}
	
	public void switchToChildWindow(WebDriver driver,String parentWindowID)
	{
		
		Set<String> child=driver.getWindowHandles();
		for(String chi:child)
		{
			if(!chi.equals(parentWindowID))
			{
			 driver.switchTo().window(chi);
			 break;
			}
		}
	}
	public void switchToParentWindow(WebDriver driver,String parentWindowID)
	{
	   driver.switchTo().window(parentWindowID);
	}
	
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);	
	}
	
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);	
	}
	
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseMoveOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
}
