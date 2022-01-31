Feature: Language Button Functionality

  Scenario Outline: TC_0201, TC_0202
    Given Hover over the Language Button
    And Select  "<language>" from the options
    Then The user should be able to see the web Page in selected "<language>"
    Examples:
      | language |
      | DE       |
      | TR       |
      | EN       |