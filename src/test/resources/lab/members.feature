Feature: Register a member account

Scenario: I have no account and want to register an account
Given I am on the SportsID register page
When I enter all the required info and click on register Button
Then I should be redirected to a confirmation page