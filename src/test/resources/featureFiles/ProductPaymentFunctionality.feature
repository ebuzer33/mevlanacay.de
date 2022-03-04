Feature: Product Payment Functionality

  Background:
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks

  Scenario: The user should be able to pay with paypal without adding the product to the cart
    When Click on the PayPal button
    Then The user should be able to see PayPal login page

  Scenario: After adding the product to the cart, the user should be able to pay with paypal
    When Click on the Warenkorb button
    When Click on the PayPal button
    Then The user should be able to see PayPal login page

  Scenario Outline: The user must be able to fill out the form on the payment page
    When Click on the Warenkorb button
    Then Click on the Weiter Zur Kasse button
    And Fill the Vorname "<Name>"
    And Fill the Nachname "<Surname>"
    And Fill the Straße "<Street>"
    And Fill the Postleitzahl "<Postal Code>"
    And Fill the Ort "<City>"
    And Fill the Telefon "<Phone>"
    And Fill the Email "<Email>"
    When Select "<Transfer>" as payment option
    When Select "<Payment by card>" as payment "<Card Type>"
    And Select the "<Terms and conditions>"
    When Click on the "<Place order>"
    Then The user should be able to see the appropriate "<Message>"

    Examples:
      | Name | Surname | Street    | Postal Code | City   | Phone       | Email            | Transfer | Payment by card | Card Type   | Terms and conditions | Place order | Message                                                        |
      |      | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | true        | Vorname ist ein Pflichtfeld                                    |
      | Alex |         | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | true        | Nachname ist ein Pflichtfeld                                   |
      | Alex | Tester  |           | 34119       | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | true        | Straße ist ein Pflichtfeld                                     |
      | Alex | Tester  | Melbourne |             | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | true        | Postleitzahl ist ein Pflichtfeld                               |
      | Alex | Tester  | Melbourne | 34119       |        | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | true        | Ort / Stadt ist ein Pflichtfeld                                |
      | Alex | Tester  | Melbourne | 34119       | Kassel |             | tester@gmail.com | true     | false           | false       | true                 | true        | Telefon ist ein Pflichtfeld                                    |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 |                  | true     | false           | false       | true                 | true        | E-Mail-Adresse ist ein Pflichtfeld                             |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | true                 | false       |                                                                |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | false    | true            | Paypal      | true                 | false       |                                                                |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | false    | true            | Lastschrift | true                 | false       |                                                                |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | false    | true            | Kreditkarte | true                 | false       |                                                                |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@gmail.com | true     | false           | false       | false                | true        | Bitte lies und akzeptiere die Allgemeinen Geschäftsbedingungen |
      | Alex | Tester  | Melbourne | 34119       | Kassel | ab123       | tester@gmail.com | true     | false           | false       | true                 | true        | Telefon ist keine gültige Telefonnummer                        |
      | Alex | Tester  | Melbourne | 34119       | Kassel | 05617397718 | tester@          | true     | false           | false       | true                 | true        | Ungültige Rechnungs E-Mail-Adresse                             |

  Scenario: TC_0827
    When Click on the Warenkorb button
    Then Click on the Weiter Zur Kasse button
    And Click on the enter Gutschein Code button
    And Fill the Gutschein Code field randomly "123ert"
    When Click on the Gutschein Anwenden button
    Then The user should be able to see Der Gutschein message

