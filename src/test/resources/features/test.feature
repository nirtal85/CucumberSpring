Feature: check

  Scenario: test
    Given I navigate to google
    And I search for "dasdas"
    Then 30 results should be found