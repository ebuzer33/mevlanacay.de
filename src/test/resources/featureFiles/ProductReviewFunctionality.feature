Feature: Product Review Functionality

  Scenario: The user should be able to see the features of the selected product
    Given Click on the Product button
    And  Click on one of the products randomly which is in the stocks
    And  Click on the Zusatzliche Informationen button
    And  The user should be able to see the additional information about the product
    And  Click on the Beschreibung button
    And  The user should be able to see the product information
    And  Click on the Bewertungen button
    Then The user should be able to see the comment section about the product

   Scenario: The user should be able to rate the selected product and comment on the product
     Given Click on the Product button
     And  Click on one of the products randomly which is in the stocks
     And  Click on the Bewertungen button
     And  Click on one of the Deine Bewentung randomly
     And  Fill the Deine Rezension field with "This product is perfect"
     And Fill the name field with "Hans"
     And Fill the e-mail field
     And Click on the Send Button
     And  Click on the Bewertungen button
     Then User should be able to see the "Dein Kommentar wartet auf Freischaltung" message

