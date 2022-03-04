package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class SocialMediaButtonFunctionality {
    private final HomePage homePage;

    public SocialMediaButtonFunctionality(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^Click on the \"([^\"]*)\" button$")
    public void clickOnTheButton(String name) {
        switch (name) {
            case "Facebook":
                homePage.getFacebookBtn().click();
                break;
            case "Twitter":
                homePage.getTwitterBtn().click();
                break;
            case "Instagram":
                homePage.getInstagramBtn().click();
                break;
            case "InstagramBottom":
                homePage.getInstagramBottomBtn().click();
                break;
        }
    }

    @Then("^The user should be able to see the \"([^\"]*)\" page of the company$")
    public void theUserShouldBeAbleToSeeThePageOfTheCompany(String socialMediaPage) {
        homePage.switchToNewTab();
        homePage.assertUrl(socialMediaPage);
    }
}

