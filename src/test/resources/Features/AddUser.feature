@ios @android
Feature: Add User

  Background:
    Given I am in Main Screen
    When I click in Add button
    Then I am in Edit_View Screen

  Scenario: Add new user
    Given I fill the following information:
      | First | Svenja |
      | Last  | Boos   |
    When I click in Save button
    When I select user with first name Svenja and last name Boos
    Then I will see the detailView for user with first name Svenja and last name Boos
    Then I click in Delete button

    Then I see a Modal Screen
    Then I Confirm Modal Screen




