@android @e2e @wip
Feature: Android Login Feature
  
  Scenario: Basic E2E for DE
    
    Given I am in Login Screen
    And  I enter happyspendit+jose1fz2707@gmail.com in field login
    And  I enter aaaaaaaaa1- in field password
    When I click Login button
    
    Then I am in AddReceipt Screen
    And I click AddReceipt button
    When I click Gallery button
    And I click verifyReceipt button
    #Then I am in UpdateReceipt Screen
    