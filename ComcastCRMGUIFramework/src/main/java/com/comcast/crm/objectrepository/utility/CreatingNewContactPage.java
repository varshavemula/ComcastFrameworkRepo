package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		 this.driver=driver;
	}
	@FindBy(id="search_txt")
	private WebElement searchfield;
	
	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="lastname")
	private WebElement contactname;
	
	public WebElement getContactname() {
		return contactname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	public WebElement getStartDate() {
		return startDate;
	}
	
	public WebElement getEndDate() {
		return endDate;
	}

	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	public void createContact(String name)
	{
		contactname.sendKeys(name);
		saveBtn.click();
	}
	
	public void createcontact(String name)
	{
		contactname.sendKeys(name);
		
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement identifyParent;
	
	public WebElement getIdemtifyParent() {
		return identifyParent;
	}

	public void createContact(String name,String startDate,String endDate)
	{
		contactname.sendKeys(name);
		this.startDate.clear();
		this.startDate.sendKeys(startDate);
		this.endDate.clear();
		this.endDate.sendKeys(endDate);
		saveBtn.click();
	}
	
}
