Feature: The form on the Contact Us page can be filled

  Scenario Outline:TC_0301,TC_0302,TC_0303,TC_0304,TC_0305,TC_0306,
  TC_0307,TC_0308,TC_0309,TC_0310,TC_0311,TC_0312,TC_0313,TC_0314,TC_0315

    Given Click on the Contact button
    When Type in the Name input "<Name>"
    And Type in the Email input "<Email>"
    And Type in the Subject input "<Subject>"
    And Type in the Description input "<Description>"
    And Click on the Send Button
    Then "<MessageDE>" or "<MessageTR>" or "<MessageEN>" should be verify

    Examples:
      | Name  | Email          | Subject | Description                        | MessageDE                               | MessageTR                               | MessageEN                        |
      | Alex  | alex@gmail.com | Cargo   | How many days does the cargo take? | Sie wurde versandt                      | Gönderildi                              | It has been sent                 |
      |       | dany@gmail.com | Cargo   | How many days does the cargo take? | Ein oder mehrere Felder sind fehlerhaft | Bir veya daha fazla alanda hata bulundu | One or more fields have an error |
      | Maria |                | Cargo   | How many days does the cargo take? | Ein oder mehrere Felder sind fehlerhaft | Bir veya daha fazla alanda hata bulundu | One or more fields have an error |
      | Jess  | jess@gmail.com |         | How many days does the cargo take? | Sie wurde versandt.                     | Gönderildi                              | It has been sent.                |
      | John  | john@gmail.com | Cargo   |                                    | Sie wurde versandt.                     | Gönderildi                              | It has been sent.                |


