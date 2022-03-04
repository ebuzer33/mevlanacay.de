package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;
import java.util.List;

public class ProductPage extends Parent {

    public ProductPage() {
        PageFactory.initElements(Drivers.getDriver(),this);
    }

    @FindBy(css ="[name='add-to-cart']")
    private WebElement addToCart;

    @FindBy(css="div.quantity>input")
    private WebElement inputProductQuantity;

    @FindBy(css="p[class=\"stock in-stock\"]")
    private WebElement stockNumber;

    @FindBy(className = "alert_wrapper")
    private WebElement updatedSuccessMessage;

    @FindBy(css ="div[id='paypal-animation-content']>div div")
    private WebElement payPall;

    @FindBy(css ="[href='#tab-description']")
    private WebElement productDescription;

    @FindBy(css ="[href='#tab-additional_information']")
    private WebElement productAdditionalInformation;

    @FindBy(css ="div[id='tab-description']>p")
    private WebElement productDescriptionArticle;

    @FindBy(css ="div[id='comments']>h2")
    private WebElement bewertungenMessage;

    @FindBy(css ="div[id='tab-additional_information']>table")
    private WebElement zusatzlicheInformationen;

    @FindBy(css= "li[class*=instock]")
    private List<WebElement> productListInStcok;

    @FindBy(css = "li[class*=instock] img")
    private List<WebElement> imgListInStock;

    @FindBy(css = "li[class*=outofstock]>div[class=\"desc\"] a")
    private List<WebElement> productListOutOfStock;

    @FindBy(xpath = "//p[@class=\"stock out-of-stock\"]")
    private  WebElement outOfStockGetText;

    @FindBy(css = "select[name=\"orderby\"]")
    private WebElement filterMenu;

    @FindBy(css = "div[class=\"shop-filters\"]>form")
    private WebElement filterBtn;

    @FindBy(css = "#menu-item-22796>ul.sub-menu>li:last-child")
    private WebElement teezubehörBtn;

    @FindBy(css ="[href='#tab-reviews']")
    private WebElement productReviews;

    @FindBy(css =".stars>span>a")
    private List<WebElement> productReviewsStars;

    @FindBy(id ="comment")
    private WebElement productReviewsCommentText;

    @FindBy(id ="author")
    private WebElement productReviewsName;

    @FindBy(id ="email")
    private WebElement productReviewsEmail;

    @FindBy(css = "iframe[class='zoid-component-frame zoid-visible']")
    private WebElement iFrame;

    public WebElement getiFrame() {
        return iFrame;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getInputProductQuantity() {
        return inputProductQuantity;
    }

    public WebElement getStockNumber() {
        return stockNumber;
    }

    public WebElement getUpdatedSuccessMessage() {
        return updatedSuccessMessage;
    }

    public WebElement getPayPall() {
        return payPall;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getProductAdditionalInformation() {
        return productAdditionalInformation;
    }

    public WebElement getProductDescriptionArticle() {
        return productDescriptionArticle;
    }

    public WebElement getBewertungenMessage() {
        return bewertungenMessage;
    }

    public WebElement getZusatzlicheInformationen() {
        return zusatzlicheInformationen;
    }

    public WebElement getProductReviews() {
        return productReviews;
    }

    public List<WebElement> getProductReviewsStars() {
        return productReviewsStars;
    }

    public WebElement getProductReviewsCommentText() {
        return productReviewsCommentText;
    }

    public WebElement getProductReviewsName() {
        return productReviewsName;
    }

    public WebElement getProductReviewsEmail() {
        return productReviewsEmail;
    }

    public List<WebElement> getProductListInStcok() {
        return productListInStcok;
    }

    public List<WebElement> getProductListOutOfStock() {
        return productListOutOfStock;
    }

    public WebElement getOutOfStockGetText() {
        return outOfStockGetText;
    }

    public WebElement getFilterMenu() {
        return filterMenu;
    }

    public WebElement getFilterBtn() {
        return filterBtn;
    }

    public WebElement getTeezubehörBtn() {
        return teezubehörBtn;
    }

    public List<WebElement> getImgListInStock() {
        return imgListInStock;
    }
}
