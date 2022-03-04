package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;

public class SubscribeToTheNewsletterFunctionality {
    private final HomePage homePage;
    private String expectedWarning;
    private String actualWarning;

    public SubscribeToTheNewsletterFunctionality(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^Type an \"([^\"]*)\" into the email input on the top of the page$")
    public void typeAnIntoTheEmailInputOnTheTopOfThePage(String email) {
        homePage.sendKeys(homePage.getEmailInputTop(), email);
        expectedWarning = homePage.getEmailInputTop().getAttribute("validationMessage");
    }

    @And("^Click on the Submit button$")
    public void clickOnTheSubmitButton() {
        homePage.clickToElement(homePage.getEmailSubscribeTop());
        actualWarning = homePage.getEmailInputTop().getAttribute("validationMessage");
    }

    @Then("^The user should see the error alert with invalid \"([^\"]*)\" or success message with valid e-mail for top registration$")
    public void theUserShouldSeeTheErrorAlertWithInvalidOrSuccessMessageWithValidEMailForTopRegistration(String email) {
        if (email.contains("@gmail.com")) {
            homePage.assertMessage(homePage.getEmailSuccessMessageTop(),
                    "Sie haben sich erfolgreich registriert! Vielen Dank. Bitte überprüfen Sie die Bestätigungs-E-Mail, die wir Ihnen gesendet haben.",
                    "Başarıyla kaydoldunuz. Teşekkürler. Lütfen size gönderdiğimiz onay mailini kontrol edin.");
        } else {
            Assert.assertEquals(expectedWarning, actualWarning);
        }
    }

    @Given("^Type an \"([^\"]*)\" into the email input on the bottom of the page$")
    public void typeAnIntoTheEmailInputOnTheBottomOfThePage(String email) {
        homePage.sendKeys(homePage.getEmailInputBottom(), email);
        expectedWarning = homePage.getEmailInputBottom().getAttribute("validationMessage");
    }

    @And("^Click on the Register button$")
    public void clickOnTheRegisterButton() {
        homePage.clickToElement(homePage.getEmailSubscribeBottom());
        actualWarning = homePage.getEmailInputBottom().getAttribute("validationMessage");
    }

    @Then("^The user should see the error alert with invalid \"([^\"]*)\" or success message with valid e-mail for bottom registration$")
    public void theUserShouldSeeTheErrorAlertWithInvalidOrSuccessMessageWithValidEMailForBottomRegistration(String email) {
        if (email.contains("@gmail.com")) {
            homePage.assertMessage(homePage.getEmailSuccessMessageBottom(),
                    "Dankeschön, Deine Anmeldung war erfolgreich!",
                    "Teşekkürler, kayıt başvurunuz başarıyla tamamlandı! Lütfen e-posta gelen kutunuzu kontrol edin.");
        } else if (email.equals("test@email")) {
            homePage.assertMessage(homePage.getEmailErrorMessageBottom(),
                    "Bitte eine gültige E-Mail Adresse angeben.",
                    "Lütfen geçerli bir e-posta adresi girin.");
        } else {
            Assert.assertEquals(expectedWarning, actualWarning);
        }
    }
}



