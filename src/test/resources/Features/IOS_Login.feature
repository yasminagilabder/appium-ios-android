@ios
Feature: IOS Login Feature
  
  Scenario: Login IOS app successfully
    Given I am in Login Screen
    And  I enter oscar.izquierdo@spendit.de in field login
    And  I enter Spendoscar1029 in field password
    When  I click login button