package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;
import java.util.List;

public class AboutUsPage extends Parent {
    public AboutUsPage() {
        PageFactory.initElements(Drivers.getDriver(),this);
    }

    @FindBy(css = "div[class=\"wpb_video_wrapper\"]>iframe")
    private List<WebElement> iframeList;

    @FindBy(css = "div[id=\"player\"]>div>div[class=\"vp-controls\"]>button")
    private WebElement playerButton;

    @FindBy(css = "div.focus-target")
    private WebElement playbackTime;

    @FindBy(id ="menu-item-21585")
    private WebElement impressum;

    @FindBy(id ="menu-item-21313")
    private WebElement faq;

    @FindBy(id ="menu-item-21589")
    private WebElement tvAds;

    public WebElement getPlaybackTime() {
        return playbackTime;
    }

    public WebElement getPlayerButton() {
        return playerButton;
    }

    public List<WebElement> getIframeList() {
        return iframeList;
    }

    public WebElement getImpressum() {
        return impressum;
    }

    public WebElement getFaq() {
        return faq;
    }

    public WebElement getTvAds() {
        return tvAds;
    }
}
