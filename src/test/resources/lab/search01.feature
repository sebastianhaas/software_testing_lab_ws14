Feature: Search member by Surname

Scenario: In the members list i want to search for specific members by their surname
Given I am logged in
Given I am in the members/list tab
Given A member with Surname TEST1 exisits
When I enter Surename TEST1
Then All members that match TEST1 should be shown