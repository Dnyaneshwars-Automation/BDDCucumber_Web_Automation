Feature: Sales Page

 @SanityTestAutomation @SalesPage @SelectDate
  Scenario Outline: Search Customer By Name
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on sales hidden button
    And click on order option
    Then verify the required date selected

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
