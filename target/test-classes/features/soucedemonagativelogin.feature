

Feature:

  Background:
    Given users goes to saucedemo login page

  Scenario: TC_Sauce_Demo_Login_Page
    Then user types invalid userName
    Then user types valid password and clicks login button
    And user checks error message and verifies it

  Scenario: TC_Sauce_Demo_Login_Page
    Then user types invalid userName
    Then user types invalid password and clicks login button
    And user checks error message and verifies it




