Feature: Register page
  	Regiter a user

  #@tag1
  #Background:
  Scenario: verify that user is present or not
    Given user able naivgate to orange HRM application
    Then enter the user "Admin" and "admin123"
    When user click on login button
    Then naviagate to PIM page
    And verify that user is able to see the "PIM" in the page