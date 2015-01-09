package at.ac.tuwien.inso.swtesten.lab;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SportsIDSearchStepDefinitions {
	
	private SportsIDSeleniumHelper helper = new SportsIDSeleniumHelper();
	
	@Given("^I am logged in$")
	public void I_am_logged_in() throws Throwable {
	    helper.setUp();
	    // login
		helper.loadLoginPage();
		helper.login_enterAccountInfo();
		helper.login_clickOnLogin();
	    helper.assertLogoutButtonVisibile();
	}

	@Given("^I am in the members/list tab$")
	public void I_am_in_the_members_list_tab() throws Throwable {
	    helper.loadMemberListPage();
		helper.assertOnMemberListPage();
	}

	@Given("^A member with Surname TEST(\\d+) exisits$")
	public void A_member_with_Surname_TEST_exisits(int arg1) throws Throwable {
	    helper.assertMemberTest1Exists();
	}

	@When("^I enter Surename TEST(\\d+)$")
	public void I_enter_Surename_TEST(int arg1) throws Throwable {
	    helper.searchForTEST1();
	}

	@Then("^All members that match TEST(\\d+) should be shown$")
	public void All_members_that_match_TEST_should_be_shown(int arg1) throws Throwable {
		helper.assertMemberTest1Exists();
	}
}
