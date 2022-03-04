package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.Drivers;
import java.time.Duration;

public class ProductPaymentFunctionality {
    private final ProductPage product;
    private final CheckOutPage checkOut;
    private final CartPage cart;
    private final WebDriverWait wait;

    public ProductPaymentFunctionality(ProductPage product, CheckOutPage checkOut, CartPage cart, HomePage homePage) {
        this.checkOut = checkOut;
        this.product = product;
        this.cart = cart;
        wait = new WebDriverWait(Drivers.getDriver(), Duration.ofSeconds(15));
    }

    @When("^Click on the PayPal button$")
    public void clickOnThePayPalButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(product.getiFrame()));
        product.clickToElement(product.getPayPall());
    }

    @Then("^The user should be able to see PayPal login page$")
    public void theUserShouldBeAbleToSeePayPalLoginPage() {
        product.switchToNewTab();
        wait.until(ExpectedConditions.urlContains("paypal"));
        product.assertUrl("paypal.com");
    }

    @Then("^Click on the Weiter Zur Kasse button$")
    public void clickOnTheWeiterZurKasseButton() {
        cart.clickToElement(cart.getCheckOutBtn());
    }

    @And("^Fill the Vorname \"([^\"]*)\"$")
    public void fillTheVorname(String name) {
        checkOut.sendKeys(checkOut.getFirstName(), name);
    }

    @And("^Fill the Nachname \"([^\"]*)\"$")
    public void fillTheNachname(String surname) {
        checkOut.sendKeys(checkOut.getLastName(), surname);
    }

    @And("^Fill the Straße \"([^\"]*)\"$")
    public void fillTheStraße(String street) {
        checkOut.sendKeys(checkOut.getAddress(), street);
    }

    @And("^Fill the Postleitzahl \"([^\"]*)\"$")
    public void fillThePostleitzahl(String postcode) {
        checkOut.sendKeys(checkOut.getPostCode(), postcode);
    }

    @And("^Fill the Ort \"([^\"]*)\"$")
    public void fillTheOrt(String city) {
        checkOut.sendKeys(checkOut.getCity(), city);
    }

    @And("^Fill the Telefon \"([^\"]*)\"$")
    public void fillTheTelefon(String phone) {
        checkOut.sendKeys(checkOut.getPhone(), phone);
    }

    @And("^Fill the Email \"([^\"]*)\"$")
    public void fillTheEmail(String email) {
        checkOut.sendKeys(checkOut.getEmail(), email);
    }

    @When("^Select \"([^\"]*)\" as payment option$")
    public void selectAsPaymentOption(String message) {
        if (message.equals("true")) {
            checkOut.javaScriptClick(checkOut.getPaymentByTransfer());
        }
    }

    @When("^Select \"([^\"]*)\" as payment \"([^\"]*)\"$")
    public void selectAsPayment(String card, String cardType) {
        if (card.equals("true")) {
            checkOut.javaScriptClick(checkOut.getPaymentByTransfer());
            checkOut.javaScriptClick(checkOut.getCreditCardRadio());
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(checkOut.getCardIframe()));
            switch (cardType) {
                case "Paypal":
                    checkOut.javaScriptClick(checkOut.getBankCard());
                    checkOut.javaScriptClick(checkOut.getPayPalCard());
                    break;
                case "Lastschrift":
                    checkOut.javaScriptClick(checkOut.getBankCard());
                    break;
                case "Kreditkarte":
                    checkOut.javaScriptClick(checkOut.getCreditCard());
                    break;
            }
            Drivers.getDriver().switchTo().defaultContent();
        }
    }

    @And("^Select the \"([^\"]*)\"$")
    public void selectThe(String term) {
        checkOut.waitUntilClickable(checkOut.getTermsAndConditions());
        if (term.equals("true")) {
            checkOut.javaScriptClick(checkOut.getTermsAndConditions());
        }
    }

    @When("^Click on the \"([^\"]*)\"$")
    public void clickOnThe(String placeOrder) {
        if (placeOrder.equals("true")) checkOut.javaScriptClick(checkOut.getPlaceOrder());
    }

    @Then("^The user should be able to see the appropriate \"([^\"]*)\"$")
    public void theUserShouldBeAbleToSeeTheAppropriate(String message) {
        if (!(message.equals(""))) {
            checkOut.assertMessage(checkOut.getErrorMessage(), message);
        }
    }

    @Then("^Click on the enter Gutschein Code button$")
    public void click_on_the_enter_Gutschein_Code_button() {
        checkOut.clickToElement(checkOut.getShowCoupon());
    }

    @Then("^Fill the Gutschein Code field randomly \"([^\"]*)\"$")
    public void fill_the_Gutschein_Code_field_randomly(String couponNo) {
        checkOut.sendKeys(checkOut.getCouponCodeInput(), couponNo);
    }

    @When("^Click on the Gutschein Anwenden button$")
    public void click_on_the_Gutschein_Anwenden_button() {
        checkOut.clickToElement(checkOut.getApplyCoupon());
    }

    @Then("^The user should be able to see Der Gutschein message$")
    public void the_user_should_be_able_to_see_Der_Gutschein_message() {
        checkOut.assertMessage(checkOut.getCouponErrorMessage(), "existiert nicht");
    }
}
