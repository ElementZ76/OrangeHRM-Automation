Feature: Admin Management

  Background:
    Given I have logged into the application
    And I navigate to the Admin page

  @JsonDriven
  Scenario: Add multiple system users from JSON
    When I add users from json file "users.json"
    Then I should see the users in the list