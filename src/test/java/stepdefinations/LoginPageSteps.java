package stepdefinations;

import org.testng.annotations.AfterMethod;

import com.webapp.qa.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps extends LoginPage {

	LoginPage loginPage;

	@Given("^user open the web page url on browser$")
	public void user_open_the_web_page_url_on_browser() throws Throwable {
		initialization();
		loginPage = new LoginPage();

	}

	@When("^user enter empty username on login page$")
	public void user_enter_empty_username_on_login_page() throws Throwable {
		loginPage.setUserName("");
	}
	
	@When("^user enter empty full name on login page$")
	public void user_enter_empty_full_name_on_login_page() throws Throwable {
		loginPage.setFullName("");
	}
	
	@When("^user enter empty password on login page$")
	public void user_enter_empty_password_on_login_page() throws Throwable {
		loginPage.setPassword("");
	}
	
	@When("^user enter valid username \"([^\"]*)\" on login page$")
	public void user_enter_valid_username_on_login_page(String username) throws Throwable {
		loginPage.setUserName(username);
	}
	
	@When("^user enter valid full name \"([^\"]*)\" on login page$")
	public void user_enter_valid_full_name_on_login_page(String fullname) throws Throwable {
		loginPage.setFullName(fullname);
	}
	
	@When("^user enter valid password \"([^\"]*)\" on login page$")
	public void user_enter_empty_username(String password) throws Throwable {
		loginPage.setPassword(password);
	}

	@When("^user clicks on login button on login page$")
	public void user_clicks_on_login_button_on_login_page() throws Throwable {
		loginPage.clickLoginButton();
	}

	@Then("^application display message \"([^\"]*)\" on login page$")
	public void application_display_message_Login_cannot_be_empty(String status) throws Throwable {
		loginPage.verifyMessageOnLoginScreen(status);
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
