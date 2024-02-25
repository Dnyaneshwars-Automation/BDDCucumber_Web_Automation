Feature: Customers Page

  @SanityTestAutomation @AddNewCustomer
  Scenario Outline: Add New Customer
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on customers hidden button
    And click on customers option
    And click on Add New button
    And enter customers information
    And click on save button
    Then verify new customer added successfully

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |

  @SanityTestAutomation @SearchCustomerwebTable
  Scenario Outline: Search Customer By TableData
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on customers hidden button
    And click on customers option
    Then customers webtable is display
    And find the number of table row
    And find the number of table column
    And find the james pan customer by name
    And retrive the all table data
    And retrive the indian cricket team customer name and customer role from table

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |

  @SanityTestAutomation @SearchCustomer @ByEmail
  Scenario Outline: Search Customer By Email
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on customers hidden button
    And click on customers option
    Then customers webtable is display
    And enter search customer "<emailAddress>"
    And click on search button
    Then verify the search result from customers table

    Examples: 
      | email               | password | emailAddress                      |
      | admin@yourstore.com | admin    | victoria_victoria@nopCommerce.com |

  @SanityTestAutomation @SearchCustomer @ByName
  Scenario Outline: Search Customer By Name
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on customers hidden button
    And click on customers option
    Then customers webtable is display
    And enter search customer by name "<customerName>"
    And click on search button
    Then verify the search result from customers table

    Examples: 
      | email               | password | customerName |
      | admin@yourstore.com | admin    | Steve        |

  @SanityTestAutomation @SearchCustomer @WithAllDetails
  Scenario Outline: Search Customer By Name
    Given user navigate to login page
    When user enterd "<email>" and "<password>"
    And click on login button
    And click on customers hidden button
    And click on customers option
    Then customers webtable is display
    And enter search customer all details
      | Email                       | FirstName | LastName | CompanyName         |
      | kiyjcycyhjc676008@gmail.com | Virat     | Kohli    | Indian Cricket Team |
      | Qyhdu@gmail.com             | John      | Doe1     | BusyQA              |
    And click on search button
    Then verify the search result from customers table

    Examples: 
      | email               | password | customerName |
      | admin@yourstore.com | admin    | Steve        |