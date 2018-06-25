
Feature: Cheese Categories
	


Background:
Given I am on the Cheesessquare app category page and "Cheesesquare" is displayed

@test1
Scenario: Check if all the 3 categories of cheese are displayed
Then the below categories should be displayed
|CATEGORY 1|
|CATEGORY 2|
|CATEGORY 3|


Scenario: Change the mode to Night(Always)
When I select the Ellipsis dots on the top right of the App
And I click on Night mode
And I select Night always mode

Scenario: Check if all the 3 sections are displayed for the selected cheese 
And I choose a cheese in the list
Then I should see "Info" "Friends" and "Related"


