@android @e2e
Feature: Android Login Feature
  
  Scenario: Basic E2E for DE
    
    Given I am in Login Screen
    And  I enter happyspendit.de.test1@gmail.com in field login
    And  I enter lindaBrown124! in field password
    When I click login button
    
    Then I am in addReceipt Screen
    And I click addReceipt button
    