package PracticeTest;

/**
 * test class for Contact module
 * @author Varsha
 * 
 */
import org.testng.annotations.Test;

import com.comcast.crm.objectrepository.utility.LoginPage;
import com.crm.comcast.basetest.BaseTest;

public class SearchContactTest extends BaseTest{

	/**
	 *  Scenario : login()==>navigateContact()==>verify
	 */
	@Test
	public void searchContactTest()
	{
		//step-1:-login to app
		LoginPage lp =new LoginPage(driver);
		lp.login("username","password");
	}
}
