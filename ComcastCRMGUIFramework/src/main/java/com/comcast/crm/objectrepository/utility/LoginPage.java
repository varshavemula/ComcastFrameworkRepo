package com.comcast.crm.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Varsha
 *
 * Contains Login page elements & bussiness lib like login()
 *
 **/
public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		  
	}
	//Object creation
		@FindBy(name="user_name")
		private WebElement username;
		
		@FindBy(name="user_password")
		private WebElement password;
		
		@FindBy(id="submitButton")
		private WebElement loginBtn;

		public WebElement getUsername() {
			return username;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		/**
		 * login to application based on username password 
		 * @param username
		 * @param password
		 */
		
		public void login(String username,String password)
		{
			this.username.sendKeys(username);
			this.password.sendKeys(password);
			loginBtn.click();
		}
}
