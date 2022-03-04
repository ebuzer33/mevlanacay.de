Feature:About Us Functionality

  Scenario:The user should be able to watch TV commercials
    Given Hover over the About Us button
    And Click on the TV Ads button
    Then Click on one of the videos randomly

  Scenario: The user should be able to use the sub-menus of the about us menu
    Given Hover over the About Us button
    Then The user should be able to see the sub menus of the About Us page
    And Click on the TV Ads button
    Then The user should be able see the TV Ads page.
    And Hover over the About Us button
    And Click on the Impressum button
    Then The user should be able to see the Impressum page
    And Hover over the About Us button
    And Click on the FAQ button
    Then The user should be able to see the FAQ page
