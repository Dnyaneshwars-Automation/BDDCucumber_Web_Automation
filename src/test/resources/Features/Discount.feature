Feature: Discount

  @DiscountSearchDate
  Scenario Outline: Search Discount Based On Search
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on promotion option and Discount Option
    Then verify user navigate on discount search page
    And enter start date and end date
    Then verify the current date and future date.

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
