Feature: Menu Functionality

   Scenario: The user should be able to click the buttons in the menu
     Given Click on the Product button
     Then User should able to see the Product Page
     And Click on the Home button
     Then The user should able to see the Home Page
     And Click on the About Us button
     Then User should be able to see the About Us Page
     And Click on the Blog button
     Then The user should be able to see the Blog Page
     And Click on the Contact button
     Then The user should be able to see the Contact Page
     Then Click on the Cart button
     Then The user should be able to see the Cart Page

  Scenario: The user should be able to reduce the size of the window and click the buttons in the menu
    Given Click on the hamburger menu icon
    And Click on the Product button
    Then User should able to see the Product Page
    And Click on the hamburger menu icon
    And Click on the Home button
    Then The user should able to see the Home Page
    And Click on the hamburger menu icon
    And Click on the About Us button
    Then User should be able to see the About Us Page
    And Click on the hamburger menu icon
    And Click on the Blog button
    Then The user should be able to see the Blog Page
    And Click on the hamburger menu icon
    And Click on the Contact button
    Then The user should be able to see the Contact Page
    And Click on the hamburger menu icon
    And Click on the Cart button
    Then The user should be able to see the Cart Page
