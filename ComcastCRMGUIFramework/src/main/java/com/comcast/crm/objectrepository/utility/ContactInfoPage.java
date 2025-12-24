package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		 this.driver=driver;
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement contactinfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateinfo;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateinfo;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement orgnameinfo;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactinfo() {
		return contactinfo;
	}

	public WebElement getOrgnameinfo() {
		return orgnameinfo;
	}

	public WebElement getContactInfo() {
		return contactinfo;	
	}

	public WebElement getStartDateinfo() {
		return startDateinfo;
	}

	public WebElement getEndDateinfo() {
		return endDateinfo;
	}
	
	
	
}
