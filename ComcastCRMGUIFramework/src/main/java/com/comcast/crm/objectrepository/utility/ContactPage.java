package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		 this.driver=driver;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createNewContactBtn;
	
	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;	
	}
}
