
Feature: Login Feature
  
  @android
  Scenario: Login Android app successfully
    Given I am in Login Screen
    And  I enter happyspendit.de.test1@gmail.com in field Login
    And  I enter lindaBrown124! in field password
    When  I click login button
    #Then I should see next page
  
  @ios
  Scenario: Login IOS app successfully
    #Given I am in Login Screen
    And  I enter oscar.izquierdo@spendit.de in field Login
    And  I enter Spendoscar1029 in field password
    When  I click login button