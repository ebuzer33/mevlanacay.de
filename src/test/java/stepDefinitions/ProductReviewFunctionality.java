package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import pages.*;
import utils.Drivers;

public class ProductReviewFunctionality {
    private final ProductPage product;
    private final HomePage homePage;

    public ProductReviewFunctionality(ProductPage product, HomePage homePage) {
        this.product = product;
        this.homePage = homePage;
    }

    @Given("^Click on the Beschreibung button$")
    public void click_on_the_Beschreibung_button() {
        product.clickToElement(product.getProductDescription());
    }

    @Given("^The user should be able to see the product information$")
    public void the_user_should_be_able_to_see_the_product_information() {
        product.getProductDescriptionArticle().isDisplayed();
    }

    @Given("^Click on the Zusatzliche Informationen button$")
    public void click_on_the_Zusatzliche_Informationen_button() {
        if (!Drivers.threadLanguage.get().equals("DE")) {
            homePage.waitUntilVisible(homePage.getCookiesAccept());
            homePage.clickToElement(homePage.getCookiesAccept());
        }
        product.clickToElement(product.getProductAdditionalInformation());
    }

    @Given("^The user should be able to see the additional information about the product$")
    public void the_user_should_be_able_to_see_the_additional_information_about_the_product() {
        product.getZusatzlicheInformationen().isDisplayed();
    }

    @Given("^Click on the Bewertungen button$")
    public void click_on_the_Bewertungen_button() {
        product.clickToElement(product.getProductReviews());
    }

    @Then("^The user should be able to see the comment section about the product$")
    public void the_user_should_be_able_to_see_the_comment_section_about_the_product() {
        product.getBewertungenMessage().isDisplayed();
    }

    @Given("^Click on one of the Deine Bewentung randomly$")
    public void click_on_one_of_the_Deine_Bewentung_randomly() {
        product.clickRandomlyFromAList(product.getProductReviewsStars());
    }

    @Given("^Fill the Deine Rezension field with \"([^\"]*)\"$")
    public void fill_the_Deine_Rezension_field_with(String deineRezension) {
        product.sendKeys(product.getProductReviewsCommentText(), deineRezension);
    }

    @Given("^Fill the name field with \"([^\"]*)\"$")
    public void fill_the_name_field_with(String name) {
        product.sendKeys(product.getProductReviewsName(), name);
    }

    @Given("^Fill the e-mail field")
    public void fill_the_e_mail_field_with() {
        String eMail = RandomStringUtils.randomAlphabetic(5) + "@eurotech.com";
        product.sendKeys(product.getProductReviewsEmail(), eMail);
    }

    @Then("^User should be able to see the \"([^\"]*)\" message$")
    public void user_should_be_able_to_see_the_message(String message) {
        product.waitUntilVisible(product.getProductDescription());
        product.assertMessage(product.getUpdatedSuccessMessage(), message);
    }
}
