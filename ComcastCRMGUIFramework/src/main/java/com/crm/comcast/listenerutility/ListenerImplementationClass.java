package com.crm.comcast.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.basetest.BaseTest;

public class ListenerImplementationClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite)
	{
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ","_").replaceAll(":", "_");
		
		
		spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Result Suite");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information & crate test
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "CHROME-11");
	}
	
	public void onFinish(ISuite suite)
	{
		System.out.println("Report backUP");
		report.flush();
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName());
		
	    test = report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.SetTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+"------->STARTED<--------");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" END");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"------->COMPLETED<--------");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {

	    String testName = result.getMethod().getMethodName();

	    // Get the actual test instance
//	    BaseTest test = (BaseTest) result.getInstance();
//	    WebDriver driver = test.driver;

	    TakesScreenshot ts = (TakesScreenshot)BaseTest.sdriver;
	    String filepath=ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replaceAll(":", "_");
	    test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);

	    test.log(Status.FAIL, result.getMethod().getMethodName()+"------->FAILED<--------");
	   
	}
}

	
	
	

