package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BlogPage;
import utils.Drivers;
import java.time.Duration;

public class BlogFunctionality {
    private final BlogPage blogPage;
    private int randomValue;
    private String beforeLikeBtnText;
    private String afterLikeBtnText;
    private String title;
    private String entryTitle;
    private final WebDriverWait wait;
    private final Actions action;

    public BlogFunctionality(BlogPage blogPage) {
        this.blogPage = blogPage;
        wait = new WebDriverWait(Drivers.getDriver(), Duration.ofSeconds(15));
        action = new Actions(Drivers.getDriver());
    }

    @And("^Click on one of the articles randomly$")
    public void clickOnOneOfTheArticlesRandomly() {
        randomValue = blogPage.randomIndexForLists(blogPage.getArticles());
        title = blogPage.getArticles().get(randomValue).getText();
        blogPage.clickToElement(blogPage.getArticles().get(randomValue));
    }

    @Then("^The user should be able to see the article$")
    public void theUserShouldBeAbleToSeeTheArticle() {
        entryTitle = blogPage.getEntryTitle().getText();
        Assert.assertEquals(title, entryTitle);
    }

    @And("^Click on one of the Read More buttons randomly$")
    public void clickOnOneOfTheReadMoreButtonsRandomly() {
        randomValue = blogPage.randomIndexForLists(blogPage.getReadMore());
        title = blogPage.getArticles().get(randomValue).getText();
        blogPage.clickToElement(blogPage.getReadMore().get(randomValue));
        entryTitle = blogPage.getEntryTitle().getText();
    }

    @And("^Hover over one of the images randomly$")
    public void hoverOverOneOfTheImagesRandomly() {
        randomValue = blogPage.randomIndexForLists(blogPage.getImageList());
        title = blogPage.getArticles().get(randomValue).getText();
        action.moveToElement(blogPage.getImageList().get(randomValue)).perform();
    }

    @And("^Click on the link button$")
    public void clickOnTheLinkButton() {
        blogPage.waitUntilVisible(blogPage.getDoubleLink().get(randomValue));
        action.moveToElement(blogPage.getProductLinkBtn().get(randomValue), 10, 0).click().perform();
    }

    @And("^Click on one of the Like buttons in the article page$")
    public void clickOnOneOfTheLikeButtonsInTheArticlePage() {
        beforeLikeBtnText = blogPage.getLikeBtn().getText();
        blogPage.clickToElement(blogPage.getLikeBtn());
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(blogPage.getLikeBtn(), beforeLikeBtnText)));
    }

    @Then("^The number of likes should be changed$")
    public void theNumberOfLikesShouldBeChanged() {
        afterLikeBtnText = blogPage.getLikeBtn().getText();
        Assert.assertNotEquals(beforeLikeBtnText, afterLikeBtnText);
    }

    @And("^Click on one of the Like buttons randomly$")
    public void clickOnOneOfTheLikeButtonsRandomly() {
        randomValue = blogPage.randomIndexForLists(blogPage.getLikeBtnList());
        beforeLikeBtnText = blogPage.getLikeBtnList().get(randomValue).getText();
        blogPage.clickToElement(blogPage.getLikeBtnList().get(randomValue));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(blogPage.getLikeBtnList().get(randomValue), beforeLikeBtnText)));
    }

    @Then("^The number of like button that the user randomly clicks should change$")
    public void theNumberOfLikeButtonThatTheUserRandomlyClicksShouldChange() {
        afterLikeBtnText = blogPage.getLikeBtnList().get(randomValue).getText();
        Assert.assertNotEquals(beforeLikeBtnText, afterLikeBtnText);
    }

    @And("^click on the randomly liked article$")
    public void clickOnTheRandomlyLikedArticle() {
        blogPage.clickToElement(blogPage.getArticles().get(randomValue));
    }

    @And("^Click on the Zoom button$")
    public void clickOnTheZoomButton() {
        blogPage.waitUntilVisible(blogPage.getDoubleLink().get(randomValue));
        action.moveToElement(blogPage.getZoomBtn().get(randomValue), 10, 10).click().perform();
    }

    @Then("^The user should see the image zoomed in$")
    public void theUserShouldSeeTheImageZoomedIn() {
        blogPage.waitUntilVisible(blogPage.getImageZoom());
        Assert.assertTrue(blogPage.getImageZoom().isDisplayed());
    }

    @And("^Click on the share on \"([^\"]*)\" button$")
    public void clickOnTheShareOnButton(String socialMediaName) {
        switch (socialMediaName) {
            case "Facebook":
                blogPage.clickToElement(blogPage.getShareFacebookBtn());
                break;
            case "Twitter":
                blogPage.clickToElement(blogPage.getShareTwitterBtn());
                break;
            case "Linkedin":
                blogPage.clickToElement(blogPage.getShareLinkedinBtn());
                break;
            case "Pinterest":
                blogPage.clickToElement(blogPage.getSharePinterestBtn());
                break;
        }
    }

    @Then("^The user should be able to share the article on the \"([^\"]*)\"$")
    public void theUserShouldBeAbleToShareTheArticleOnThe(String newPage) {
        blogPage.switchToNewTab();
        blogPage.assertUrl(newPage);
    }

    @And("^Send \"([^\"]*)\" to the Search input$")
    public void sendToTheSearchInput(String word) {
        blogPage.sendKeys(blogPage.getSearchInputBtn(), word);
        blogPage.pressEnter(blogPage.getSearchInputBtn());
    }

    @Then("^The user should be able to see the \"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\"of the relevant search result$")
    public void theUserShouldBeAbleToSeeTheOfTheRelevantSearchResult(String messageDE, String messageTR, String messageEN) {
        if (blogPage.getSearchResult().getText().contains("tee")) {
            blogPage.assertMessage(blogPage.getSearchResult(), messageDE, messageTR, messageEN);
        } else {
            blogPage.assertMessage(blogPage.getSearchNoResult(), messageDE, messageTR, messageEN);
        }
    }

    @And("^Click on the Next Page button$")
    public void clickOnTheNextPageButton() {
        blogPage.clickToElement(blogPage.getNextPage());
    }

    @Then("^The user should be able to see the articles on the next page$")
    public void theUserShouldBeAbleToSeeTheArticlesOnTheNextPage() {
        blogPage.assertUrl("page");
    }
}


