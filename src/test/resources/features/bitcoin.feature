@bitcoin
Feature: Bitcoin specific test

  Scenario: Checking bitcoin quantity available for a price
    Given I fetch bitcoin price data
#    Then There are more than 50 bitcoin available
#    And The price is less than 10845 USD
    Then I sort the data
