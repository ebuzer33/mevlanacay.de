Feature: Social Media Button Functionality

  Scenario Outline:The user must be able to open the social media accounts of the company
    Given Click on the "<Social Media>" button
    Then The user should be able to see the "<SocialMediaPage>" page of the company
    Examples:
      | Social Media    | SocialMediaPage |
      | Facebook        | facebook        |
      | Twitter         | twitter         |
      | Instagram       | instagram       |
      | InstagramBottom | instagram       |






