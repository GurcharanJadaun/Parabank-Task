@regression
Feature: Test user registration for the bank
  @Test1 
  Scenario: new user
    Given I navigate to URL
    And I verify ParaBank page is displayed
    And I generate data for 2 user

    #-- create bank account for user 2
    When I click on Register Link on login panel
    Then I verify user registration form is available
    And I fill the form details with user 2 details
    And I click Register button on Registration panel
    And I make user 2 account has been created

    #get Bank account Information
    When I click on Accounts Overview on Account service tab
    And I verify bank account information is being displayed
    And I store bank account information for user 2
    When I click on Log Out on Account service tab   

    #-- create bank account for user 1
    And I verify ParaBank page is displayed
    When I click on Register Link on login panel
    Then I verify user registration form is available
    And I fill the form details with user 1 details
    And I click Register button on Registration panel
    And I make user 1 account has been created
     
    #get Bank account Information
    When I click on Accounts Overview on Account service tab
    And I verify bank account information is being displayed
    And I store bank account information for user 1
    
    #make a transaction
    When I click on Bill Pay on Account service tab
    Then I verify Bill Payment Service is displayed on Bill Service Panel
    And I send an amount of 300 from user 1 to user 2
    And I verify Bill Payment Complete is displayed on Bill Service Panel
    And I verify Success Message is displayed
     
    #verify the transaction
    When I click on Accounts Overview on Account service tab
    And I click on Account number in row 1
    Then I verify Account Details header is displayed
    And I verify there is a Debit transaction of 300.00 dollars towards user 2
    And I click on Log Out on Account service tab   
    
    
   