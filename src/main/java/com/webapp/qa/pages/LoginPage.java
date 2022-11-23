package com.webapp.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.webapp.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	
	@FindBy(css = "input#username")
	WebElement txtUserName;
	
	@FindBy(css = "input#name")
	WebElement txtFullName;
	
	@FindBy(css = "input#password")
	WebElement txtPassword;
	
	@FindBy(css = "input#submit")
	WebElement btnLogin;
	
	@FindBy(css = "font[id='status']")
	WebElement status;
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		txtUserName.sendKeys(username);
	}
	
	public void setFullName(String fullname) {
		txtFullName.sendKeys(fullname);;
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);;
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public void verifyMessageOnLoginScreen(String message) throws InterruptedException {
		Assert.assertTrue(status.getText().equals(message)); 
	}

}
