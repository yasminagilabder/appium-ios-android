Feature: Login Feature
  
  Scenario: Login the app successfully
    Given I am in Login Screen
    And  I enter happyspendit.de.test1@gmail.com in field Login
    And  I enter lindaBrown124! in field password
    When  I click login button
    #Then I should see next page