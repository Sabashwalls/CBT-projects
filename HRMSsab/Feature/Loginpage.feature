Feature: User Login
  As a user
  I want to login to the application
  So that I can access my account

  Background: common steps for each scenario
    Given user should navigate to appication url

  Scenario: Login with valid username and password
    Given I am on the login page
    When I enter valid username and password
    And I click on the Login button
    Then I should be logged into the applications

  Scenario: Login with valid username and invalid password
    When user enter valid username and invalidpassword
    And Click on the Login button
    Then user should see the message error message for invalid password

  Scenario: Login with invalid username and validpassword
    When user enter invalid username and valid password
    And Click on the Login button
    Then user should see the message error message for invalid username

  Scenario: Login with invalid username and invalidpassword
    When user enter invalid username and invalid password
    And Click on the Login button
    Then user should see the message error message for both username and password

  Scenario: Login without credentials
    When user not enter credentials
    And Click on the Login button
    Then user should see the message error message for both username and password

  Scenario: Login with only username and no password
    When user gives only username without giving the password
    And Click on the Login button
    Then I should see an error message indicating invalid login credentials

  Scenario: Login with only password and no username
    When user gives only password without giving the username
    And Click on the Login button
    Then I should see an error message indicating invalid login credentials

  Scenario: Login with only invalid username and no password
    When user gives only invalid username without giving the password
    And Click on the Login button
    Then I should see an error message indicating invalid login credentials

  Scenario: Login with only invalid password and no username
    When user gives only invalid password without giving the username
    And Click on the Login button
    Then I should see an error message indicating invalid login credentials
    
    Scenario: Verify password field masking
    When user enter password in the password field
    Then the password should be masked in the password field
