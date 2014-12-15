Feature: Add to basket

Scenario: Add product to basket
Given I am on the john lewis site
When I select laptop and macbooks from the mega menu
When I click on the Acer laptop
Then I should be taken to the Acer Laptop product page
When I add the acer laptop to the basket
Then item is succesfully added to basket