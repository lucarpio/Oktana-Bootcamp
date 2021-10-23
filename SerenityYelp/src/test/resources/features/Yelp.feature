Feature: Search Yelp

  Background:
    Given User navigates to https://www.yelp.com/
    And Selects find Restaurants

  Scenario Outline: Detail of the first restaurant search result
    Given User search restaurant <type>
    When Filters by <neighborhood>
    And Select the first search result
    Then User views restaurant information

    Examples:

      | type  | neighborhood |
      | Pizza | Glen Park    |