Feature:Blog Functionality

  Background:
    When Click on the Blog button
    Then The user should be able to see the Blog Page

  Scenario: TC_0401
    And Click on one of the articles randomly
    Then The user should be able to see the article

  Scenario: TC_0402
    And Click on one of the Read More buttons randomly
    Then The user should be able to see the article

  Scenario:  TC_0403
    And Hover over one of the images randomly
    And Click on the link button
    Then The user should be able to see the article

  Scenario: TC_0404
    And Click on one of the articles randomly
    And Click on one of the Like buttons in the article page
    Then The number of likes should be changed

  Scenario: TC_0405
    And Click on one of the Like buttons randomly
    Then The number of like button that the user randomly clicks should change

  Scenario:tc
    And Click on one of the Like buttons randomly
    And click on the randomly liked article
    Then The number of likes should be changed

  Scenario: TC_0406
    And Hover over one of the images randomly
    And Click on the Zoom button
    Then The user should be able to see the same picture

  Scenario Outline:TC_0407, TC_0408, TC_0409, TC_0410
    And Click on one of the articles randomly
    And Click on the share on "<Social Media>" button
    Then The user should be able to share the article on the "<New Page>"

    Examples:
      | Social Media | New Page  |
      | Facebook     | facebook  |
      | Twitter      | twitter   |
      | Pinterest    | pinterest |
      | Linkedin     | linkedin  |

  Scenario Outline: TC_0411, TC_0412, TC_0413
    And Click on one of the articles randomly
    And Send "<Search Word>" to the Search input
    Then The user should be able to see the "<MessageDE>" ,"<MessageTR>","<MessageEN>"of the relevant search result
    Examples:
      | Search Word | MessageDE                | MessageTR        | MessageEN        |
      | tee         | Ergebnisse gefunden      | sonuçlar         | results found    |
      | hello       | Keine Ergebisse gefunden | Sonuç bulunamadı | No results found |


  Scenario:TC_0414
    And Click on the Next Page button
    Then The user should be able to see the articles on the next page
