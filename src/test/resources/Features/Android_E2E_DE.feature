@android @e2e
Feature: Android Login Feature
  
  Scenario: Basic E2E for DE
    
    Given I am in Login Screen
    And  I enter happyspendit.de.test1@gmail.com in field login
    And  I enter lindaBrown124! in field password
    When I click Login button
    Then I am in AddReceipt Screen
    
    Given I click AddReceipt button
    And I click Gallery button
    When I click verifyReceipt button
    Then I am in Category Screen
    
    
    
    Then I am in UpdateReceipt Screen
    
    Given I update Amount to 30
    When I click SubmitReceipt button
    Then I am in Refund Screen
    
    When I click Done button in Refund Screen
    
    When I click Done button in Refund Screen
    
    Then I am in Feedback Screen
    
    When I click Close button
    Then I am in AddReceipt Screen
    
    When I click Receipt Link
    Then I am in AllReceipts Screen
    
    When I click CurrentMonth Link
    Then I am in EditReceipt Screen
    
    When I click ShowReceipt button
    And I click Delete button
    When I click Done button in Refund Screen
    And I click LogOut Link
    Then I am in Login Screen
    
   
    






    
    
    
    