package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import utils.Drivers;
import java.time.Duration;

public class AboutUsFunctionality {

    private final AboutUsPage aboutUsPage;
    private final HomePage homePage;
    private final WebDriverWait wait;

    public AboutUsFunctionality(AboutUsPage aboutUsPage, HomePage homePage) {
        this.aboutUsPage = aboutUsPage;
        this.homePage = homePage;
        wait = new WebDriverWait(Drivers.getDriver(), Duration.ofSeconds(15));
    }

    @Then("^Click on one of the videos randomly$")
    public void clickOnOneOfTheVideosRandomly() {
        for (int i = 0; i < aboutUsPage.getIframeList().size(); i++) {

            Drivers.getDriver().switchTo().frame(i);
            String beforePlayback = aboutUsPage.getPlaybackTime().getAttribute("aria-valuenow");
            aboutUsPage.clickToElement(aboutUsPage.getPlayerButton());
            wait.until(ExpectedConditions.attributeContains(aboutUsPage.getPlaybackTime(), "aria-valuenow", "5"));
            String afterPlayback = aboutUsPage.getPlaybackTime().getAttribute("aria-valuenow");
            aboutUsPage.clickToElement(aboutUsPage.getPlayerButton());
            Drivers.getDriver().switchTo().defaultContent();
            Assert.assertNotEquals(beforePlayback, afterPlayback);
        }
    }

    @Given("^Hover over the About Us button$")
    public void hover_over_the_About_Us_button() {
        aboutUsPage.hoverOverRandomlyOnAnElement(homePage.getAboutUsBtn());
    }

    @Then("^The user should be able to see the sub menus of the About Us page$")
    public void the_user_should_be_able_to_see_the_sub_menus_of_the_Uber_Uns_page() {
        boolean submenuEnabled = homePage.getAboutUsSubmenu().isEnabled();
        Assert.assertTrue(submenuEnabled);
    }

    @And("^Click on the TV Ads button$")
    public void clickOnTheTVSpotsButton() {
        aboutUsPage.getTvAds().click();
    }

    @Then("^The user should be able see the TV Ads page\\.$")
    public void theUserShouldBeAbleSeeTheTVAdsPage() {
        aboutUsPage.assertUrl("tv-spots", "tv-reklamlari", "tv-ads");
    }

    @And("^Click on the Impressum button$")
    public void clickOnTheImpressumButton() {
        aboutUsPage.getImpressum().click();
    }

    @Then("^The user should be able to see the Impressum page$")
    public void theUserShouldBeAbleToSeeTheImpressumPage() {
        aboutUsPage.assertUrl("impressum", "kunye", "impressum");
    }

    @And("^Click on the FAQ button$")
    public void clickOnTheFAQButton() {
        aboutUsPage.getFaq().click();
    }

    @Then("^The user should be able to see the FAQ page$")
    public void theUserShouldBeAbleToSeeTheFAQPage() {
        aboutUsPage.assertUrl("haufig-gestellte-fragen", "sss", "faq");
    }
}
