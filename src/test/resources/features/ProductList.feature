@all
Feature: Validate Product List


  Scenario: User is able to register

    Given Login into the site
    Then Get all the product lists 
    And check the particular product "<Sauce Labs Bolt T-Shirt>" is available
    