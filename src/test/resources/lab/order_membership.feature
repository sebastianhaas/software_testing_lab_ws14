Feature: Login into system

Scenario: I want to order memberships for multiple existing user
Given I am logged in with an admin user
Given I am on the SportsID home screen
When I navigate to buy membership page
Then I see the members list
When I select multiple users in the table
When I click on review selected button
Then I am redirected to the review selected page
When I click on payment & shipping button
Then I am redirected to the payment and shipping subpage
When I fill in email and address
When I click the confirm button
Then I am redirected to the confirm subpage
When I click the place order button
Then I am redirected to a page containing payment details