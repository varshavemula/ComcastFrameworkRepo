package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutitly.ExcelUtility;
import com.comcast.crm.generic.fileutitly.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.utility.HomePage;
import com.comcast.crm.objectrepository.utility.LoginPage;
import com.comcast.crm.objectrepository.utility.OrganisationInfoPage;
import com.comcast.crm.objectrepository.utility.OrganisationPage;
import com.comcast.crm.objectrepository.utility.creatingNewOrganisationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String browser=flib.getDataFromPropertyFile("browser");
		String url=flib.getDataFromPropertyFile("url");
		String user=flib.getDataFromPropertyFile("username");
		String psw=flib.getDataFromPropertyFile("password");
		
		//Read TestScript data from Excel file
		
		 String orgname=elib.getDtaFromExcel("createOrg", 1, 2)+ jlib.getRandomNumber();
		 String shipAddress=elib.getDtaFromExcel("createOrg", 1, 3);
		 
		System.out.println("Enter the broswer");
		WebDriver driver;
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
	    wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
     	driver.get(url);
     	LoginPage lp=new LoginPage(driver);
  	  
 	   lp.login("admin", "admin");
 	  
 	   HomePage hp=new HomePage(driver);
 	   wlib.waitForElementPresent(driver, hp.getOrgLink());
 	   hp.getOrgLink().click();
 	   
 	   OrganisationPage op=new OrganisationPage(driver);
 	   op.getCreateNewOrgBtn().click();
 	   
 	   creatingNewOrganisationPage cp=new creatingNewOrganisationPage(driver);
 	   cp.createOrg(orgname, shipAddress);
 	  OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String headerInfo=oip.getHeaderInfo().getText();
		if(headerInfo.contains(orgname))
			System.out.println(orgname+ " is created==PASS");
		else
			System.out.println(orgname+ "is not created==FAIL");
		
		//Verify Orgname info Expected result
		
		//String OrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		String OrgName=oip.getOrgname().getText();
		if(OrgName.equals(orgname))
			System.out.println(orgname+ " is created==PASS");
		else
			System.out.println(orgname+ "is not created==FAIL");
		
		//go back to Organisation page
	 	   hp.getOrgLink().click();
	 	   
	 	   //Search for organisation
	 	   op.getSearchText().sendKeys(orgname);
	 	   wlib.select(op.getSearchDD(), "accountname");
	 	   op.getSearchBtn().click();
	 	   
	 	   driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		
		driver.quit();
	}

}
