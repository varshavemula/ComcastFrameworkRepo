package com.crm.comcast.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutitly.ExcelUtility;
import com.comcast.crm.generic.fileutitly.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.utility.HomePage;
import com.comcast.crm.objectrepository.utility.LoginPage;

public class BaseTest {

	//create an object 
	public FileUtility flib=new FileUtility();
	public	ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public	DataBaseUtility dblib=new DataBaseUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	public LoginPage lp;
	public HomePage hp;
	
	
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void beforeSuite() throws Throwable
	{
		System.out.println("connect to DB and report config");
		dblib.getDBConnection();
	}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void aftersuite() throws Throwable 
	{
		System.out.println("close DB amd Report backup");
		dblib.closeDBConnection();

	}
	
	//@Parameters("browser")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void beforeclass() throws Throwable
	{
		System.out.println("launch the browser");
		String browser=flib.getDataFromPropertyFile("browser");
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		sdriver=driver;
		UtilityClassObject.SetDriver(driver);
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void afterclass()
	{
		System.out.println("close the browser");
		driver.quit();
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void beforemethod() throws Throwable
	{
		System.out.println("login");
		String url=flib.getDataFromPropertyFile("url");
	   String username=flib.getDataFromPropertyFile("username");
	   String password=flib.getDataFromPropertyFile("password");
	   driver.get(url);
	   driver.manage().window().maximize();
	   wlib.waitForPageToLoad(driver);
	   lp=new LoginPage(driver);
	   lp.login(username, password);
	   
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void aftermethod()
	{
		System.out.println("logout");
		hp=new HomePage(driver);
		hp.getAdminImg().click();
		hp.getSignoutLink().click();
	}
}
