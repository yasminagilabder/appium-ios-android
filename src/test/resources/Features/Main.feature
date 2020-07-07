@ios @android
Feature: Main flow

  Scenario: Select User
    Given I am in Main Screen
    When I select user with first name Floyd and last name Bell
    Then I will see the detailView for user with first name Floyd and last name Bell
    Given I click in back button


