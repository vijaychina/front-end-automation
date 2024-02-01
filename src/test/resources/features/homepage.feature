Feature: Homepage top menu functionality
    As a User I want to check the homepage functionality

  Scenario:   User should navigate to Online Slots page successfully
    Given     I am on Homepage
    And       I have clicked on cookies
    And       I verify the header links from 'Top Menu'
    When      I click on link All Games in top menu
    Then      I navigate to "Online Slots" page