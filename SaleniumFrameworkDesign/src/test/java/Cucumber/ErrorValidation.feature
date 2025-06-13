Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Validate the User Login Credential.
  	Given I landed on Ecom page
    When Login with username <user> and password <pass>
    Then verify the "Incordrect email or password." for the Login credential.

    Examples: 
      | user                 | pass       |
      | harigovinmd@gmail.com | Welcome123 |