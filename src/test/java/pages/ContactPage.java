package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;

public class ContactPage extends Parent {
    public ContactPage() {
        PageFactory.initElements(Drivers.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement subjectInput;

    @FindBy(css = "span>textarea")
    private WebElement messageInput;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    private WebElement sendButton;

    @FindBy(css = ".wpcf7-response-output")
    private WebElement successAndFailMessage;

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getSubjectInput() {
        return subjectInput;
    }

    public WebElement getMessageInput() {
        return messageInput;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getSuccessAndFailMessage() {
        return successAndFailMessage;
    }
}
