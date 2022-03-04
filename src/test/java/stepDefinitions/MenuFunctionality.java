package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.Drivers;
import java.time.Duration;

public class MenuFunctionality {

    private final HomePage homePage;
    private final WebDriverWait wait;
    private final Actions actions;

    public MenuFunctionality(HomePage homePage) {
        this.homePage = homePage;
        actions = new Actions(Drivers.getDriver());
        wait = new WebDriverWait(Drivers.getDriver(), Duration.ofSeconds(10));
    }

    @Given("^Click on the Product button$")
    public void click_on_the_Product_button() {
        homePage.clickToElement(homePage.getProductBtn());
    }

    @Then("^User should able to see the Product Page$")
    public void user_should_able_to_see_the_Product_Page() {
        if (Drivers.threadLanguage.get().equals("DE")) {
            homePage.assertUrl("produkte");
        } else {
            homePage.assertUrl("shop");
        }
    }

    @Then("^Click on the Home button$")
    public void click_on_the_Home_button() {
        homePage.clickToElement(homePage.getHomeBtn());
    }

    @Then("^The user should able to see the Home Page$")
    public void the_user_should_able_to_see_the_Home_Page() {
        homePage.assertUrl("mevlanacay.de");

        if (Drivers.threadLanguage.get().equals("TR")) {
            if (Drivers.getDriver().manage().window().getSize().getHeight() == 640) {
                homePage.waitUntilVisible(homePage.getCookiesAccept());
                homePage.clickToElement(homePage.getCookiesAccept());
                homePage.javaScriptClick(homePage.getHamburgerMenu());
                homePage.javaScriptClick(homePage.getToggleFlags());
                homePage.clickToElement(homePage.getTcFlag());
            } else {
                actions.moveToElement(homePage.getAllFlags()).build().perform();
                homePage.clickToElement(homePage.getTcFlag());
            }

        } else if (Drivers.threadLanguage.get().equals("EN")) {
            if (Drivers.getDriver().manage().window().getSize().getHeight() == 640) {
                homePage.waitUntilVisible(homePage.getCookiesAccept());
                homePage.clickToElement(homePage.getCookiesAccept());
                homePage.javaScriptClick(homePage.getHamburgerMenu());
                homePage.clickToElement(homePage.getToggleFlags());
                homePage.clickToElement(homePage.getEnFlag());
            } else {
                actions.moveToElement(homePage.getAllFlags()).build().perform();
                homePage.clickToElement(homePage.getEnFlag());
            }
        }
    }

    @Then("^Click on the About Us button$")
    public void click_on_the_About_Us_button() {
        homePage.clickToElement(homePage.getAboutUsBtn());
    }

    @Then("^User should be able to see the About Us Page$")
    public void user_should_be_able_to_see_the_About_Us_Page() {
        homePage.assertUrl("uber-uns", "hakkimizda", "aboutus");
    }

    @Then("^Click on the Blog button$")
    public void click_on_the_Blog_button() {
        homePage.clickToElement(homePage.getBlogBtn());
    }

    @Then("^The user should be able to see the Blog Page$")
    public void the_user_should_be_able_to_see_the_Blog_Page() {
        homePage.assertUrl("de/blog", "/tr/blog", "/en/blog");
    }

    @Then("^Click on the Contact button$")
    public void click_on_the_Contact_button() {
        homePage.clickToElement(homePage.getContactBtn());
    }

    @Then("^The user should be able to see the Contact Page$")
    public void the_user_should_be_able_to_see_the_Contact_Page() {
        homePage.assertUrl(".de/kontakt", "/tr/iletisim", "/en/contact");
    }

    @Then("^Click on the Cart button$")
    public void click_on_the_Cart_button() {
        if (Drivers.threadLanguage.get().equals("DE") && Drivers.getDriver().manage().window().getSize().getHeight() == 640) {
            homePage.clickToElement(homePage.getMobilCart());
        } else if (Drivers.threadLanguage.get().equals("DE")) {
            homePage.clickToElement(homePage.getTopCart());
        }
    }

    @Then("^The user should be able to see the Cart Page$")
    public void the_user_should_be_able_to_see_the_Cart_Page() {
        if (Drivers.threadLanguage.get().equals("DE")) {
            homePage.assertUrl("warenkorb");
        }
    }

    @Given("^Click on the hamburger menu icon$")
    public void clickOnTheHamburgerMenuIcon() {
        if (!Drivers.getDriver().getCurrentUrl().contains("de/en") && homePage.getEmailMessage().isDisplayed()) {
            homePage.javaScriptClick(homePage.getCloseEMail());
            wait.until(ExpectedConditions.invisibilityOf(homePage.getEmailMessage()));
        }
        if (Drivers.getDriver().manage().window().getSize().getHeight() != 640) {
            Drivers.getDriver().manage().window().setSize(new Dimension(360, 640));
        }
        homePage.javaScriptClick(homePage.getHamburgerMenu());
        homePage.waitUntilVisible(homePage.getProductBtn());
    }
}
