package at.ac.tuwien.inso.swtesten.lab;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SportsIDStepDefinitions {

	private SportsIDSeleniumHelper helper = new SportsIDSeleniumHelper();
	private SportsIDRegisterSeleniumHelper registerHelper = new SportsIDRegisterSeleniumHelper();

	// ################################################## 
	// ################### LOGIN TEST ################### 
	// ################################################## 
	@Given("^I am on the SportsID Login page$")
	public void I_am_on_the_SportsID_Login_page() throws Throwable {
		helper.setUp();
		helper.loadLoginPage();
		helper.assertOnLoginPage();
	}

	@When("^I enter my Account and click on Login Button$")
	public void I_enter_my_Account_and_click_on_Login_Button() throws Throwable {
		helper.login_enterAccountInfo();
		helper.login_clickOnLogin();
	}

	@Then("^I should be logged in and i should be redirected to Homescreen$")
	public void I_should_be_logged_in_and_i_should_be_redirected_to_Homescreen() throws Throwable {
		helper.assertLogoutButtonVisibile();
		helper.tearDown();
	}

	// ################################################## 
	// ############## REGISTRATION TEST ################# 
	// ################################################## 

	@Given("^I am on the SportsID register page$")
	public void I_am_on_the_SportsID_register_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    registerHelper.setUp();
	    registerHelper.loadLoginPage();
	}

	@When("^I enter all the required info and click on register Button$")
	public void I_enter_all_the_required_info_and_click_on_register_Button() throws Throwable {
	    registerHelper.testUntitled();
	}

	@Then("^I should be redirected to a confirmation page$")
	public void I_should_be_redirected_to_a_confirmation_page() throws Throwable {
		registerHelper.successTextVisible();
	}
}
