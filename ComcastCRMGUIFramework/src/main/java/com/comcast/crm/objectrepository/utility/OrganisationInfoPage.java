package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
	 WebDriver driver;
		public OrganisationInfoPage(WebDriver driver)
		{
			 PageFactory.initElements(driver,this);
			 this.driver=driver;
		}
     @FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement headerInfo;
     
     @FindBy(id="dtlview_Organization Name")
     private WebElement orgname;
     
     
	 public WebElement getHeaderInfo() {
		 return headerInfo;
	 }
	 
	 public WebElement getType() {
		 return type;
	 }
	 
	 public WebElement getindustry() {
		 return industry;
	 }

	 public WebElement getphoneNumber() {
		 return phoneNumber;
	 }

	 public WebElement getOrgname() {
		 return orgname;
	 }
     
     @FindBy(id="dtlview_Industry")
     private WebElement industry;
    
     
     @FindBy(id="dtlview_Type")
     private WebElement type;
    
     @FindBy(id="dtlview_Phone")
     private WebElement phoneNumber;
	 
}
