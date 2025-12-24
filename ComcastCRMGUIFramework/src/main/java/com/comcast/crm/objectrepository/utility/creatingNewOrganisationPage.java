package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class creatingNewOrganisationPage {
	 WebDriver driver;
		public creatingNewOrganisationPage(WebDriver driver)
		{
			 PageFactory.initElements(driver,this);
			 this.driver=driver;
		}
		@FindBy(name="accountname")
		private WebElement orgname;
		
		@FindBy(name="button")
		private WebElement saveBtn;
		
		@FindBy(name="industry")
		private WebElement industryDD;
		
		@FindBy(name="phone")
		private WebElement phoneNumber;
		
		@FindBy(name="ship_street")
		private WebElement shippingaddress;
		
		@FindBy(name="accounttype")
		private WebElement accountDD;
		
		public WebElement getIndustryDD() {
			return industryDD;
		}

		public WebElement getOrgname() {
			return orgname;
		}
		
		public WebElement getshippingAddress() {
			return shippingaddress;
		}
		
		public WebElement getAccountDD() {
			return accountDD;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getPhoneNumber() {
			return phoneNumber;
		}
		
		public void createOrg(String orgname,String shippingaddress)
		{
			this.orgname.sendKeys(orgname);
			this.shippingaddress.sendKeys(shippingaddress);
			saveBtn.click();	
		}
		
		public void createOrg(String orgname,String shippingaddress,String industry,String type)
		{
			Select sel=new Select(industryDD);
			Select se=new Select(accountDD);
			this.orgname.sendKeys(orgname);
			this.shippingaddress.sendKeys(shippingaddress);
			sel.selectByVisibleText(industry);
			se.selectByVisibleText(type);
			saveBtn.click();	
		}
		
		public void createOrg(String orgname,String shippingaddress,String phone)
		{
			this.orgname.sendKeys(orgname);
			this.shippingaddress.sendKeys(shippingaddress);
	        this.phoneNumber.sendKeys(phone);
			saveBtn.click();	
		}
		
		
}
