#@browser @ui-tests
#Feature: google look up
#
#  Scenario Outline: searching for a text <text> on Search Engine <searchEngine>
#    Given I go to <searchEngine>
#    When I enter text <text> into search bar of search engine <searchEngine>
#    Then I land on correct page
#    Examples:
#      | text          | searchEngine |
##     | Hello World  | Google       |
##     | Hello World  | DuckDuckGo   |
##      | Olympic Games | Wikipedia    |
#      | EN5 5SQ       | Maps         |
#Feature: directions for maps
#
#  Scenario Outline: finding directions to <location> from <work>
#    Given I go to Maps
#    When I enter location <location> into Maps
#    And I click on directions button
#    Then I type in work <work> location
#    And I click on search button
#    Examples:
#      | location | work          |
#      | EN5 5SQ  | 150 Cheapside |