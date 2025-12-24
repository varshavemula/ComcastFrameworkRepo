package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutitly.ExcelUtility;
import com.comcast.crm.generic.fileutitly.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.utility.ContactInfoPage;
import com.comcast.crm.objectrepository.utility.ContactPage;
import com.comcast.crm.objectrepository.utility.CreatingNewContactPage;
import com.comcast.crm.objectrepository.utility.HomePage;
import com.comcast.crm.objectrepository.utility.LoginPage;
import com.comcast.crm.objectrepository.utility.OrganisationPage;
import com.comcast.crm.objectrepository.utility.creatingNewOrganisationPage;
import com.crm.comcast.basetest.BaseTest;

/**
 * @author varsha
 */
@Listeners(com.crm.comcast.listenerutility.ListenerImplementationClass.class)
public class ContactModule extends BaseTest{

	@Test(groups="smokeTest")
	public void createContact() throws Exception, Exception
	{
		
		
		//Read TestScript data from Excel file
		String contactname=elib.getDtaFromExcel("contact", 1,2)+jlib.getRandomNumber();
		 
		   HomePage hp=new HomePage(driver);
		   hp.getContactLink().click();
		   
		   ContactPage cp=new ContactPage(driver);
		   cp.getCreateNewContactBtn().click();
		   
		   CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		   ccp.createContact(contactname);
		
		   ContactInfoPage ci=new ContactInfoPage(driver);
		   String lastname= ci.getContactInfo().getText();
		
		   boolean status=lastname.contains(contactname);
			Assert.assertTrue(status);
	}
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Exception
	{
		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		 String name=elib.getDtaFromExcel("contact", 7, 5) + jlib.getRandomNumber();
		 String orgName=elib.getDtaFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		 String shipAddress=elib.getDtaFromExcel("contact", 7, 4);
		 
		 UtilityClassObject.gettest().log(Status.INFO, "navigate to Org Page");
		 
		   HomePage hp=new HomePage(driver);
		   wlib.waitForElementPresent(driver, hp.getOrgLink());
		   hp.getOrgLink().click();
		   
		   UtilityClassObject.gettest().log(Status.INFO, "navigate to create Org Page");
		   OrganisationPage op=new OrganisationPage(driver);
		   op.getCreateNewOrgBtn().click();
		   
		   UtilityClassObject.gettest().log(Status.INFO, "create a new org");
		   creatingNewOrganisationPage cp=new creatingNewOrganisationPage(driver);
		   cp.createOrg(orgName, shipAddress);
		   UtilityClassObject.gettest().log(Status.INFO, orgName+"--->create a new Org");
		Thread.sleep(2000);
		  hp.getContactLink().click();
		 ContactPage conp=new ContactPage(driver);
		   conp.getCreateNewContactBtn().click();
		   CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		   ccp.createcontact(name);
		
		 String ID=wlib.getParentWindowID(driver);
		ccp.getIdemtifyParent().click();
			//switch to child 
	    wlib.switchToChildWindow(driver, ID);
		ccp.getSearchfield().sendKeys(orgName);
		ccp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
		wlib.switchToParentWindow(driver, ID);
		
		ccp.getSaveBtn().click();
		Thread.sleep(2000);
		 ContactInfoPage ci=new ContactInfoPage(driver);
		
		String actOrgName = ci.getOrgnameinfo().getText().trim();		    

		boolean status=actOrgName.equals(orgName);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(status);
		soft.assertAll();
	}
	
	@Test(groups="regressionTest")
	public void createContactWithSupportDate() throws Exception, Exception
	{
		//Read TestScript data from Excel file
		
		 String name=elib.getDtaFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		
		String startDate=jlib.getSystemDateDDMMYYYY();
		String endDate=jlib.getRequiredDateDDMMYYYY(30);
		
		   HomePage hp=new HomePage(driver);
		   hp.getContactLink().click();
		   
		   ContactPage cp=new ContactPage(driver);
		   cp.getCreateNewContactBtn().click();
		   CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		   ccp.createContact(name,startDate,endDate);
		   
		 ContactInfoPage ci=new ContactInfoPage(driver);
		String actStartDate=ci.getStartDateinfo().getText();
		boolean status=actStartDate.contains(startDate);
		Assert.assertTrue(status);
		String actendDate=ci.getEndDateinfo().getText();
		boolean status1=actendDate.contains(endDate);
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(status1);
        soft.assertAll();
	}
}
