Feature: Login Feature
  
  @android
  Scenario Outline: Login Android app successfully
    Given I am in Login Screen
    And  I enter <login> in field Login
    And  I enter <password> in field password
    When  I click login button
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