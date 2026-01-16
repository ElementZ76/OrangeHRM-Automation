Feature: PIM Employee Management

  Background:
    Given I have logged into the application

  @JsonDriven
  Scenario: Bulk create employees from JSON
    Given I navigate to the PIM module
    When I add new employees from json file "employees.json"
    Then the employees should be created successfully