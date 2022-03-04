package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utils.Drivers;

public class LanguageButtonFunctionality {
    private final HomePage homePage;
    private final Actions actions;

    public LanguageButtonFunctionality(HomePage homePage) {
        this.homePage = homePage;
        actions = new Actions(Drivers.getDriver());
    }

    @Given("^Hover over the Language Button$")
    public void hoverOverTheLanguageButton() {
        actions.moveToElement(homePage.getAllFlags()).build().perform();
    }

    @And("^Select  \"([^\"]*)\" from the options$")
    public void selectFromTheOptions(String language) {
        if (language.equals("DE")) {
            homePage.clickToElement(homePage.getDeFlag());
        } else if (language.equals("TR")) {
            homePage.clickToElement(homePage.getTcFlag());
        } else {
            homePage.clickToElement(homePage.getEnFlag());
        }
    }

    @Then("^The user should be able to see the web Page in selected \"([^\"]*)\"$")
    public void theUserShouldBeAbleToSeeTheWebPageInSelected(String language) {
        if (language.equals("DE")) {
            homePage.assertUrl("mevlanacay.de");
        } else if (language.equals("TR")) {
            homePage.assertUrl("de/tr");
        } else {
            homePage.assertUrl("de/en/");
        }
    }
}
