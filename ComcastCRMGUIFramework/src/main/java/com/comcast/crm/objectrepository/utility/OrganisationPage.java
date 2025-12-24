package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

    WebDriver driver;
	public OrganisationPage(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		 this.driver=driver;
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(name="search_field")
	private WebElement search;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	public WebElement getSearchText() {
		return searchDD;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSearchDD() {
		return search;
	}
}
