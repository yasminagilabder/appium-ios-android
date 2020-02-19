@android @e2e @wip
Feature: Basic E2E for AT
  
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

   Then I am in EditReceipt screen for Category: 1

    Given I update Amount to 2.4
    When I click SubmitReceipt button
    Then I am in Refund Screen
    When I click AddNew button
    And I click Gallery button
    When I click verifyReceipt button
    Then I am in Category Screen
    When I click Category2 button
    Then I am in EditReceipt screen for Category: 2

    Given I update Amount to 4
    When I click SubmitReceipt button
    Then I am in Refund Screen
    When I click Done button in Refund Screen
    Then I am in Feedback Screen
    When I click Close button
    Then I am in AddReceipt Screen

    When I click Receipt Link
    Then I am in AllReceipts Screen

    When I click CurrentMonth Link
    And I click LastReceipt Link
    Then I am in EditReceipt Screen
    And I click Delete button
    
    When I click CurrentMonth Link
    Then I am in EditReceipt Screen
    And I click Delete button
    When I click Done button in AllReceipts Screen
    And I click LogOut Link
    Then I am in Login Screen
    
    