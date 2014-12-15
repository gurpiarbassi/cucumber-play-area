Feature: Browse slectricals category

Scenario: Successful browse of electricals category
Given I am on the john lewis site
When I select laptop and macbooks from the mega menu
Then I should be taken to the Laptop and Macbooks category landing page
When I click on the Acer laptop
Then I should be taken to the Acer Laptop product page