Feature: Language Button Functionality

  Scenario Outline: The user should be able to change the language of the page
    Given Hover over the Language Button
    And Select  "<language>" from the options
    Then The user should be able to see the web Page in selected "<language>"
    Examples:
      | language |
      | DE       |
      | TR       |
      | EN       |
