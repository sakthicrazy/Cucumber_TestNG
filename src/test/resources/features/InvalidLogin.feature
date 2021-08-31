@all
Feature: Login User


  Scenario: Login to application

    Given Login into the site with Invalid username and password
    Then Validate the error message
