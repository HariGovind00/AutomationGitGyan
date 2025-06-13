
Feature: Order online
  I want to use this template for my feature file

	Background:
	Given I landed on Ecom page

  @Regression
  Scenario Outline: Postive scenario for Purchasing and submitting the order
    Given Login with username <user> and password <pass>
    When Add products <productName> to AddMyCart
    And Checkout the select products <productName> and submit the order
    Then verify the "Thankyou for the order." message is displayed successfully on confirmation page.

    Examples: 
      | user                 | pass       |productName|
      | harigovind@gmail.com | Welcome123 |zara coat 3|