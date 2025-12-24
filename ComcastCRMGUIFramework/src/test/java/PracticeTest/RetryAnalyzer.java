package PracticeTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {

	@Test(retryAnalyzer=com.crm.comcast.listenerutility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("createInvoiceTest");
	
		Assert.assertEquals("","Login");
		System.out.println("step-1");
		System.out.println("step-2");  
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
