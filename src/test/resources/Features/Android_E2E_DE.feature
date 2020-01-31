@android @e2e
Feature: Android Login Feature
  
<<<<<<< HEAD:src/test/resources/Features/Android_E2E_DE.feature
  Scenario: Basic E2E for DE
=======
  @android
  Scenario Outline: Login Android app successfully
>>>>>>> 86915fc8af8c92ddd44ea9b6049ea1e294c6dc55:src/test/resources/Features/Login.feature
    Given I am in Login Screen
    And  I enter <login> in field Login
    And  I enter <password> in field password
    When  I click login button
<<<<<<< HEAD:src/test/resources/Features/Android_E2E_DE.feature
    Then I am in addReceipt Screen
    Given I click addReceipt button
  
  
=======
    Examples:
      | login                              | password       |
      | happyspendit.de.test1@gmail.com    | lindaBrown124! |
      | happyspendit+jose1fz2707@gmail.com | aaaaaaaaa1-    |
     
    #Then I should see next page
  
  @ios
  Scenario: Login IOS app successfully
    Given I am in Login Screen
    And  I enter oscar.izquierdo@spendit.de in field Login
    And  I enter Spendoscar1029 in field password
    When  I click login button
>>>>>>> 86915fc8af8c92ddd44ea9b6049ea1e294c6dc55:src/test/resources/Features/Login.feature
