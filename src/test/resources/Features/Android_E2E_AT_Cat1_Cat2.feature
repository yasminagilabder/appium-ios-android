@android @e2e @wip
Feature: Android Login Feature
  
  Scenario: Basic E2E for AT
    
    Given I am in Login Screen
    And  I enter happyspendit.at.test1@gmail.com in field login
    And  I enter Amadeusmozart123! in field password
    When I click Login button
    Then I am in AddReceipt Screen
    
    Given I click AddReceipt button
    And I click Gallery button
    When I click verifyReceipt button
    Then I am in Category Screen
    When I click Category1 button
    
   # Then I am in EditReceipt screen for Category: 2
    
    Given I update Amount to 2
    When I click SubmitReceipt button
    Then I am in Refund Screen
    When I click AddNew button
    And I click Gallery button
    When I click verifyReceipt button
    Then I am in Category Screen
    When I click Category2 button
  
    Given I update Amount to 4
    When I click SubmitReceipt button
    Then I am in Refund Screen
    When I click Done button
  
    Then I am in Feedback Screen
    When I click Close button
    Then I am in AddReceipt Screen

    When I click Receipt Link
    Then I am in AllReceipts Screen

    When I click CurrentMonth Link
    Then I am in EditReceipt Screen

    When I click ShowReceipt button
    And I click Delete button
    And I click Done button
    And I click LogOut Link
    Then I am in Login Screen
    
    