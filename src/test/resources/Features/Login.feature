Feature: Validate Login Page

  @SanityTestAutomation_Login
  Scenario Outline: login with valid email and valid password
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    Then user validate title of homepage

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |

  @SanityTestAutomation_Login1
  Scenario Outline: login with valid email and invalid password
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    Then user validate error message with invalid password

     Examples: 
      | email               | password |
      | admin@yourstore.com | xyz    |
