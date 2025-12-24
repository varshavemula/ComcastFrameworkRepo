package PracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutitly.ExcelUtility;

public class GetProductInfoTest {

	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String productName)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://amazon.com");
		driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String rating=driver.findElement(By.xpath("//span[text()='"+productName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-icon-alt']")).getText();
		System.out.println(rating);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getRowCount("product");
		System.out.println(rowcount);
		Object[][] obj =new Object[rowcount][2];
		for(int i=1;i<=rowcount;i++)
		{
		obj[i-1][0]=elib.getDtaFromExcel("product", i, 0);
		obj[i-1][1]=elib.getDtaFromExcel("product", i, 1);
		}
		return obj;	
	}
}
