Feature:Blog Functionality

  Background:
    When Click on the Blog button
    Then The user should be able to see the Blog Page

  Scenario: User should be able to click on a article
    And Click on one of the articles randomly
    Then The user should be able to see the article

  Scenario: User should be able to click the read more button
    And Click on one of the Read More buttons randomly
    Then The user should be able to see the article

  Scenario:The user should be able to click the link button on the image
    And Hover over one of the images randomly
    And Click on the link button
    Then The user should be able to see the article

  Scenario:The user should be able to click the like button inside the article
    And Click on one of the articles randomly
    And Click on one of the Like buttons in the article page
    Then The number of likes should be changed

  Scenario: The user should be able to click the like button on the blog page
    And Click on one of the Like buttons randomly
    Then The number of like button that the user randomly clicks should change

  Scenario:After clicking the like button on the blog page, the user should see that the number of likes on the article page has changed
    And Click on one of the Like buttons randomly
    And click on the randomly liked article
    Then The number of likes should be changed

  Scenario: The user should be able to click the zoom button on the image
    And Hover over one of the images randomly
    And Click on the Zoom button
    Then The user should see the image zoomed in

  Scenario Outline:The user should be able to share the article with the social media buttons
    And Click on one of the articles randomly
    And Click on the share on "<Social Media>" button
    Then The user should be able to share the article on the "<New Page>"

    Examples:
      | Social Media | New Page  |
      | Facebook     | facebook  |
      | Twitter      | twitter   |
      | Pinterest    | pinterest |
      | Linkedin     | linkedin  |

  Scenario Outline: The user should be able to search for a word he wrote in the search input on the article page
    And Click on one of the articles randomly
    And Send "<Search Word>" to the Search input
    Then The user should be able to see the "<MessageDE>" ,"<MessageTR>","<MessageEN>"of the relevant search result
    Examples:
      | Search Word | MessageDE                | MessageTR        | MessageEN        |
      | tee         | Ergebnisse gefunden      | sonuçlar         | results found    |
      | hello       | Keine Ergebisse gefunden | Sonuç bulunamadı | No results found |


  Scenario:The user should be able to click the next page button on the blog page
    And Click on the Next Page button
    Then The user should be able to see the articles on the next page

