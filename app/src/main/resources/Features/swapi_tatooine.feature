Feature: Make sure the API has information about Tatooine
  As a user
  I want to get information about Tatooine

  Scenario: Name is Tatooine
    When I make a API call
    Then Tatooine is the planet name