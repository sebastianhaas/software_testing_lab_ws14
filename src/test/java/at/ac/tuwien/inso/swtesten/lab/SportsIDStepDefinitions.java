package at.ac.tuwien.inso.swtesten.lab;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SportsIDStepDefinitions {
	
	private SportsIDSeleniumHelper helper = new SportsIDSeleniumHelper();
	
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
	
	
}
