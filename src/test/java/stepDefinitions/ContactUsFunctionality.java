package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;

public class ContactUsFunctionality {
    private final ContactPage contactPage;

    public ContactUsFunctionality(ContactPage contactPage) {
        this.contactPage = contactPage;
    }

    @When("^Type in the Name input \"([^\"]*)\"$")
    public void typeInTheNameInput(String inputName) {
        contactPage.sendKeys(contactPage.getNameInput(), inputName);
    }

    @And("^Type in the Email input \"([^\"]*)\"$")
    public void typeInTheEmailInput(String inputEmail) {
        contactPage.sendKeys(contactPage.getEmailInput(), inputEmail);
    }

    @And("^Type in the Subject input \"([^\"]*)\"$")
    public void typeInTheSubjectInput(String inputSubject) {
        contactPage.sendKeys(contactPage.getSubjectInput(), inputSubject);
    }

    @And("^Type in the Description input \"([^\"]*)\"$")
    public void typeInTheDescriptionInput(String inputDescription) {
        contactPage.sendKeys(contactPage.getMessageInput(), inputDescription);
    }

    @And("Click on the Send Button")
    public void clickOnTheSendButton() {
        contactPage.clickToElement(contactPage.getSendButton());
    }

    @Then("{string} or {string} or {string} should be verify")
    public void orOrShouldBeVerify(String messageDE, String messageTR, String messageEN) {
        contactPage.waitUntilVisible(contactPage.getSuccessAndFailMessage());
        contactPage.assertMessage(contactPage.getSuccessAndFailMessage(), messageDE, messageTR, messageEN);
    }
}

