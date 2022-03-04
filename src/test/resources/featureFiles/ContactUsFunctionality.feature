Feature: The form on the Contact Us page can be filled

  Scenario Outline:The user must be able to fill in the form on the contact page and send it completely,
  or not to fill in the form incompletely and send it

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



