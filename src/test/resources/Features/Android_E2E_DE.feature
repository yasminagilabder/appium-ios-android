@android @e2e @wip
Feature: Android Login Feature
  
  Scenario: Basic E2E for DE
    
    Given I am in Login Screen
    #And  I enter happyspendit+jose1fz2707@gmail.com in field login
    And  I enter happyspendit.de.test1@gmail.com in field login
  
    #And  I enter aaaaaaaaa1- in field password
    And  I enter lindaBrown124! in field password
    When I click Login button
    Then I am in AddReceipt Screen
    
    
    Given I click AddReceipt button
    And I click Gallery button
    When I click verifyReceipt button
    Then I am in UpdateReceipt Screen
    
    
    Given I update Amount to 30
    When I click SubmitReceipt button
    Then I am in Refund Screen
    
    When I click Done button
    Then I am in Feedback Screen
    And I click Close button
    Then I am in AddReceipt Screen
    
    When I click Receipt Link
    Then I am in AllReceipts Screen
    
    Given I click CurrentMonth Link
    
    Then I am in EditReceipt Screen
    When I click ShowReceipt button
    
    And I click Delete button
    And I click Done button
    
    And I click LogOut Link
    Then I am in Login Screen
    
   
    






    
    
    
    