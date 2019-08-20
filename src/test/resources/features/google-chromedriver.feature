@api
Feature: Checking ChromeDriver version

  Scenario: Checking ChromeDriver version
    Given I fetch Chromedriver version
    Then I get the latest version 76.0.3809.68
