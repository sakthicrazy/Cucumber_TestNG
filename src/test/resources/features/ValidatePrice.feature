@all
Feature: Validate Product List


  Scenario: User is able to register

    Given Login into the site
    Then Get the price of all products
    And Remove the dollar symbol
    And Validate the price with product listing