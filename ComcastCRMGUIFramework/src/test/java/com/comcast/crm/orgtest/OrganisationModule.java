package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutitly.ExcelUtility;
import com.comcast.crm.generic.fileutitly.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.utility.HomePage;
import com.comcast.crm.objectrepository.utility.LoginPage;
import com.comcast.crm.objectrepository.utility.OrganisationInfoPage;
import com.comcast.crm.objectrepository.utility.OrganisationPage;
import com.comcast.crm.objectrepository.utility.creatingNewOrganisationPage;
import com.crm.comcast.basetest.BaseTest;

/**
 * @author varsha
 */
public class OrganisationModule extends BaseTest{

	@Test(groups="smokeTest")
	public void createOrgTest() throws Exception
	{

		//Read TestScript data from Excel file
		
		 String orgname=elib.getDtaFromExcel("createOrg", 1, 2)+ jlib.getRandomNumber();
		 String shipAddress=elib.getDtaFromExcel("createOrg", 1, 3);
	     HomePage hp=new HomePage(driver);
	     wlib.waitForElementPresent(driver, hp.getOrgLink());
	     hp.getOrgLink().click();
	   
	   OrganisationPage op=new OrganisationPage(driver);
	   op.getCreateNewOrgBtn().click();
	   
	   creatingNewOrganisationPage cp=new creatingNewOrganisationPage(driver);
	   cp.createOrg(orgname, shipAddress);
	   
		//String HeaderInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String headerInfo=oip.getHeaderInfo().getText();
		boolean status=headerInfo.contains(orgname);
		//Assert.assertEquals(status,true);
		Assert.assertTrue(status);
		
		//String OrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		String OrgName=oip.getOrgname().getText();
		boolean status1=OrgName.equals(orgname);
		Assert.assertTrue(status1);
		
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithIndustry() throws Exception
	{
	
		String psw=flib.getDataFromPropertyFile("password");
	
		//Read TestScript data from Excel file
		
		 String orgname=elib.getDtaFromExcel("createOrg", 4, 2) + jlib.getRandomNumber();
		 String shipAddress=elib.getDtaFromExcel("createOrg", 4, 3);
		 String actIndustry=elib.getDtaFromExcel("createOrg", 4, 3);
		 String actType=elib.getDtaFromExcel("createOrg", 4, 4);
		
		   HomePage hp=new HomePage(driver);
		   wlib.waitForElementPresent(driver, hp.getOrgLink());
		   hp.getOrgLink().click();
		   
		   OrganisationPage op=new OrganisationPage(driver);
		   op.getCreateNewOrgBtn().click();
		   
		   creatingNewOrganisationPage cp=new creatingNewOrganisationPage(driver);
		   cp.createOrg(orgname, shipAddress, actIndustry,actType);
		   
		//verify industry Expected Result
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String Industry=oip.getindustry().getText();
		boolean status=Industry.equals(actIndustry);
			SoftAssert soft=new SoftAssert();
		soft.assertTrue(status);
		//Verify type dropdown info Expected result
	   
		String Type=oip.getType().getText();
		boolean status1=Type.equals(actType);
		soft.assertTrue(status1);
		soft.assertAll();
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithPhoneNumber() throws Exception
	{
		
		
		//Read TestScript data from Excel file
		
		 String orgname=elib.getDtaFromExcel("createOrg", 7, 2) + jlib.getRandomNumber();
		 String shipAddress=elib.getDtaFromExcel("createOrg", 7, 2);
		 String phone=elib.getDtaFromExcel("createOrg", 7, 2);
		
		   HomePage hp=new HomePage(driver);
		   wlib.waitForElementPresent(driver, hp.getOrgLink());
		   hp.getOrgLink().click();
		   
		   OrganisationPage op=new OrganisationPage(driver);
		   op.getCreateNewOrgBtn().click();
		   
		   creatingNewOrganisationPage cp=new creatingNewOrganisationPage(driver);
		   cp.createOrg(orgname, shipAddress, phone);
		   
		//verify industry Expected Result
		   OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		   String PhNo=oip.getphoneNumber().getText();
		  boolean status=PhNo.equals(phone);
			SoftAssert soft=new SoftAssert();
		 soft.assertTrue(status);
		 soft.assertAll();
			
	}
}
