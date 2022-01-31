package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;

import java.util.List;

public class BlogPage extends Parent {
    public BlogPage() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    @FindBy(xpath = "//a//i[@class='icon-search']")
    private List<WebElement> zoomBtn;

    @FindBy(xpath = "//a//i[@class='icon-link']")
    private List<WebElement> productLinkBtn;

    @FindBy(xpath = "//div//a[@class='next_page']")
    private WebElement nextPage;

    @FindBy(css = "div[class=\"mask\"]+img")
    private List<WebElement> producImageList;

    @FindBy(css = "figure>[class=\"mfp-img\"]")
    private WebElement imageZoom;

    @FindBy(css = "div[class=\"post-title\"] a")
    private List<WebElement> articles;

    @FindBy(css = "h1[class=\"entry-title\"]")
    private WebElement entryTitle;

    @FindBy(className = "post-more")
    private List<WebElement> readMore;

    @FindBy(css = "div[class='icons']")
    private WebElement shareFacebookBtn;

    @FindBy(className = "icon-twitter")
    private WebElement shareTwitterBtn;

    @FindBy(className = "icon-linkedin")
    private WebElement shareLinkedinBtn;

    @FindBy(css = "a[class='pinterest']")
    private WebElement sharePinterestBtn;

    @FindBy(css = "aside input[class=\"field\"]")
    private WebElement searchInputBtn;

    @FindBy(css = "div[class=\"button-love\"]")
    private WebElement likeBtn;

    @FindBy(css = "div[class=\"button-love\"]")
    private List<WebElement> likeBtnList;

    @FindBy(css = "div[class=\"column one\"]>h1")
    private WebElement searchResult;

    @FindBy(css = "div[class=\"snf-desc\"]>h4")
    private WebElement searchNoResult;

    public WebElement getEntryTitle() {
        return entryTitle;
    }

    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getSearchNoResult() {
        return searchNoResult;
    }

    public List<WebElement> getLikeBtnList() {
        return likeBtnList;
    }

    public List<WebElement> getZoomBtn() {
        return zoomBtn;
    }

    public List<WebElement> getProductLinkBtn() {
        return productLinkBtn;
    }

    public WebElement getNextPage() {
        return nextPage;
    }

    public List<WebElement> getProducImageList() {
        return producImageList;
    }

    public WebElement getImageZoom() {
        return imageZoom;
    }

    public List<WebElement> getArticles() {
        return articles;
    }

    public List<WebElement> getReadMore() {
        return readMore;
    }

    public WebElement getShareFacebookBtn() {
        return shareFacebookBtn;
    }

    public WebElement getShareTwitterBtn() {
        return shareTwitterBtn;
    }

    public WebElement getShareLinkedinBtn() {
        return shareLinkedinBtn;
    }

    public WebElement getSharePinterestBtn() {
        return sharePinterestBtn;
    }

    public WebElement getSearchInputBtn() {
        return searchInputBtn;
    }

    public WebElement getLikeBtn() {
        return likeBtn;
    }
}

