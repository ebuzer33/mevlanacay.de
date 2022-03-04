Feature: Subscribe To The Company's Newsletter

  Scenario Outline: The user should be able to subscribe to the company's newsletter from the registration section in the top menu
    Given Type an "<e-mail>" into the email input on the top of the page
    And Click on the Submit button
    Then The user should see the error alert with invalid "<e-mail>" or success message with valid e-mail for top registration
    Examples:
      | e-mail                |
      |                       |
      | test                  |
      | test@                 |
      | test@gmail.           |
      | @                     |
      | randomtest5@gmail.com |

  Scenario Outline: The user should be able to subscribe to the company's newsletter from the registration section in the bottom menu.
    Given Type an "<e-mail>" into the email input on the bottom of the page
    And Click on the Register button
    Then The user should see the error alert with invalid "<e-mail>" or success message with valid e-mail for bottom registration
    Examples:
      | e-mail                |
      |                       |
      | test                  |
      | test@                 |
      | test@gmail.           |
      | @                     |
      | randomtest9@gmail.com |
