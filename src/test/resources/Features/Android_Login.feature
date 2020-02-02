@android
Feature: Android Login Feature
  
  
  Scenario Outline: Login Android app successfully
    Given I am in Login Screen
    And  I enter <login> in field login
    And  I enter <password> in field password
    When  I click login button
  
    Then I am in addReceipt Screen
    And I click addReceipt button
    Examples:
      | login                              | password       |
      | happyspendit.de.test1@gmail.com    | lindaBrown124! |
      | happyspendit+jose1fz2707@gmail.com | aaaaaaaaa1-    |
  