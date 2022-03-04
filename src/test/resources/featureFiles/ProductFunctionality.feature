Feature:Product Functionality

  Scenario: The user should be able to see the sub menus of the Product page
    Given Hover over the Product Button
    Then  User should be able to see the sub menus of the Product page
    Then  Click on the sub menus of the Product Button

  Scenario: The user should be able to add a product in stock to the cart
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks
    When Click on the Warenkorb button
    Then The product should have been added to the cart

  Scenario: The user should be able to change the quantity of a product in stock before adding it to the cart
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks
    And Before the user can add the product to the cart, the product quantity must be changed according to the stock quantity
    When Click on the Warenkorb button
    Then The correct number of the products should have been added to the cart

  Scenario: The user should be able to change the quantity after adding the product to the cart
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks
    And Click on the Warenkorb button
    And After the user adds the product to the cart, the product quantity should be changed according to the stock amount
    When Click on the Warenkorb Aktualisieren button
    Then The user should be able to update the cart

  Scenario: The user should be able to delete the product added to the cart
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks
    And Click on the Warenkorb button
    When Click on the delete X button
    Then The user should be able to delete the product from the cart

  Scenario: The user should be able to click the link button in the product image
    Given Click on the Product button
    And Hover over one of the product images at random
    When Click on the product link button
    Then The user should be able to see the product details

  Scenario: The user should be able to click on the cart button on the product image
    Given Click on the Product button
    And Hover over one of the products image randomly which is in the stocks
    When Click on the Cart icon
    Then The product should have been added to the cart

  Scenario: The user should be able to add the product deleted from the cart back to the cart
    Given Click on the Product button
    And Hover over one of the products image randomly which is in the stocks
    And Click on the Cart icon
    And Click on the delete X button
    When Click on the Rückgängig button
    Then The user should be able to re add the product to the cart

  Scenario: The user should be able to continue shopping after adding the product to the cart
    Given Click on the Product button
    And Hover over one of the products image randomly which is in the stocks
    And Click on the Cart icon
    When Click on the Weiter Einkaufen button
    Then User should able to see the Product Page

  Scenario:TC_0810
    Given Click on the Product button
    When Click on one of the products randomly which is in the out of stocks
    Then The out of stock message should be seen

  Scenario Outline:The user should not be able to add more than the stock amount or less than the stock amount to the cart
    Given Click on the Product button
    And Click on one of the products randomly which is in the stocks
    And Before adding the product to the cart, the user must change the product quantity to zero or one more than the stock quantity "<productQuantity>"
    When Click on the Warenkorb button
    Then The user should be able to see the warning that you cannot add more or zero products than the stock amount of the product
    Examples:
      | productQuantity |
      | 1               |
      | 0               |

