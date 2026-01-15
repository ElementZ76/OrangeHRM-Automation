Feature: Admin Management

  Background:
    Given I have logged into the application
    And I navigate to the Admin page

  @DataDriven
  Scenario: Add multiple system users from Excel
    When I add users from excel "UserData.xlsx" sheet "Sheet1"
    Then I should see the users in the list