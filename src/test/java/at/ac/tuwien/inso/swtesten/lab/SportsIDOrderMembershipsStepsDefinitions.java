package at.ac.tuwien.inso.swtesten.lab;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SportsIDOrderMembershipsStepsDefinitions {

	SportsIdOrderMembershipsSeleniumHelper order = new SportsIdOrderMembershipsSeleniumHelper();
	
	@Given("^I am logged in with an admin user$")
	public void I_am_logged_in_with_an_admin_user() throws Throwable {
		order.setUp();
		order.loadLoginPage();
	    order.assertOnLoginPage();
	    order.login_enterAccountInfo();
		order.login_clickOnLogin();
	}

	@Given("^I am on the SportsID home screen$")
	public void I_am_on_the_SportsID_home_screen() throws Throwable {
		order.assertLogoutButtonVisibile();
	}

	@When("^I navigate to buy membership page$")
	public void I_navigate_to_buy_membership_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    order.navigateToOrderMembership();
	}

	@Then("^I see the members list$")
	public void I_see_the_members_list() throws Throwable {
		order.assertOnOrderMembershipPage();
	}

	@When("^I select multiple users in the table$")
	public void I_select_multiple_users_in_the_table() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    order.selectMembers();
	}

	@When("^I click on review selected button$")
	public void I_click_on_review_selected_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    order.clickReviewSelected();
	}

	@Then("^I am redirected to the review selected page$")
	public void I_am_redirected_to_the_review_selected_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
	}

	@When("^I click on payment & shipping button$")
	public void I_click_on_payment_shipping_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   order.clickPaymentShipping();
	}

	@Then("^I am redirected to the payment and shipping subpage$")
	public void I_am_redirected_to_the_payment_and_shipping_subpage() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
	}

	@When("^I fill in email and address$")
	public void I_fill_in_email_and_address() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    order.fillForm();
	}

	@When("^I click the confirm button$")
	public void I_click_the_confirm_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   order.clickConfirm();
	}

	@Then("^I am redirected to the confirm subpage$")
	public void I_am_redirected_to_the_confirm_subpage() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
	}

	@When("^I click the place order button$")
	public void I_click_the_place_order_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    order.clickPlaceOrder();
	}

	@Then("^I am redirected to a page containing payment details$")
	public void I_am_redirected_to_a_page_containing_payment_details() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		order.tearDown();
	}
}
