@android @e2e
Feature: Android Login Feature
  
  Scenario: Basic E2E for DE
    
    Given I am in Login Screen
    And  I enter  happyspendit+jose1fz2707@gmail.com in field login
    And  I enter aaaaaaaaa1- in field password
    When  I click login button
    
    Then I am in addReceipt Screen
    And I click addReceipt button
    