package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;

import java.util.List;

public class HomePage extends Parent {
    public HomePage() {
        PageFactory.initElements(Drivers.getDriver(),this);
    }

    @FindBy(css = "button[data-cf-action=\"accept\"]")
    private WebElement cookiesAccept;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailInputTop;

    @FindBy(css = "label[class='mctb-response-label']")
    private WebElement emailSuccessMessageTop;

    @FindBy(css = "div[class=\"mc4wp-alert mc4wp-error\"]>p")
    private WebElement emailErrorMessageBottom;

    @FindBy(className = "mctb-button")
    private WebElement emailSubscribeTop;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(1)")
    private WebElement homeBtn;

    @FindBy(xpath = "(//ul[@id='menu-ana-menu']//li)[2]")
    private WebElement productBtn;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(3)")
    private WebElement aboutUsBtn;

    @FindBy(xpath = "//span[text()='BLOG']")
    private WebElement blogBtn;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(5)")
    private WebElement contactBtn;

    @FindBy(xpath = "//a[text()='Facebook']")
    private WebElement facebookBtn;

    @FindBy(xpath = "//a[text()=' Instagram']")
    private WebElement instagramBtn;

    @FindBy(xpath = "//a[text()=' Twitter']")
    private WebElement twitterBtn;

    @FindBy(css = "div#sbi_load>span>a")
    private WebElement instagramBottomBtn;

    @FindBy(className = "icon-bag-fine")
    private WebElement topCart;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(6)")
    private WebElement allFlags;

    @FindBy(id = "menu-item-22453")
    private WebElement tcFlag;

    @FindBy(id = "menu-item-22455")
    private WebElement enFlag;

    @FindBy(id = "menu-item-22454")
    private WebElement deFlag;

    @FindBy(className = "mctb-close")
    private WebElement closeEMail;

    @FindBy(className = "icon-menu-fine")
    private WebElement hamburgerMenu;

    @FindBy(id = "slide-cart")
    private WebElement mobilCart;

    @FindBy(xpath = "(//li//span[@class='menu-toggle'])[3]")
    private WebElement toggleFlags;

    @FindBy(className = "mctb-label")
    private WebElement emailMessage;

    @FindBy(css = "li[id='menu-item-21588']>ul.sub-menu[style='display: block;']")
    private WebElement aboutUsSubmenu;

    @FindBy(css = "li[id='menu-item-22796']>ul.sub-menu[style='display: block;']")
    private WebElement productSubMenu;

    @FindBy(css = "#menu-item-22796>ul a")
    private List<WebElement> productSubMenuList;

    @FindBy(css = "input[name='EMAIL']")
    private WebElement emailInputBottom;

    @FindBy(css = "center>input")
    private WebElement emailSubscribeBottom;

    @FindBy(css = "div[class='mc4wp-alert mc4wp-success']>p")
    private WebElement emailSuccessMessageBottom;

    @FindBy(css = ".widget_mfn_menu ul li a")
    private List<WebElement> footerMenuList;

    public WebElement getCookiesAccept() {
        return cookiesAccept;
    }

    public WebElement getEmailInputTop() {
        return emailInputTop;
    }

    public WebElement getEmailSuccessMessageTop() {
        return emailSuccessMessageTop;
    }

    public WebElement getEmailSubscribeTop() {
        return emailSubscribeTop;
    }

    public WebElement getHomeBtn() {
        return homeBtn;
    }

    public WebElement getProductBtn() {
        return productBtn;
    }

    public WebElement getAboutUsBtn() {
        return aboutUsBtn;
    }

    public WebElement getBlogBtn() {
        return blogBtn;
    }

    public WebElement getContactBtn() {
        return contactBtn;
    }

    public WebElement getFacebookBtn() {
        return facebookBtn;
    }

    public WebElement getInstagramBtn() {
        return instagramBtn;
    }

    public WebElement getTwitterBtn() {
        return twitterBtn;
    }

    public WebElement getInstagramBottomBtn() {
        return instagramBottomBtn;
    }

    public WebElement getTopCart() {
        return topCart;
    }

    public WebElement getAllFlags() {
        return allFlags;
    }

    public WebElement getTcFlag() {
        return tcFlag;
    }

    public WebElement getEnFlag() {
        return enFlag;
    }

    public WebElement getDeFlag() {
        return deFlag;
    }

    public WebElement getCloseEMail() {
        return closeEMail;
    }

    public WebElement getHamburgerMenu() {
        return hamburgerMenu;
    }

    public WebElement getMobilCart() {
        return mobilCart;
    }

    public WebElement getToggleFlags() {
        return toggleFlags;
    }

    public WebElement getEmailMessage() {
        return emailMessage;
    }

    public WebElement getAboutUsSubmenu() {
        return aboutUsSubmenu;
    }

    public WebElement getProductSubMenu() {
        return productSubMenu;
    }

    public List<WebElement> getProductSubMenuList() {
        return productSubMenuList;
    }

    public WebElement getEmailInputBottom() {
        return emailInputBottom;
    }

    public WebElement getEmailSubscribeBottom() {
        return emailSubscribeBottom;
    }

    public WebElement getEmailSuccessMessageBottom() {
        return emailSuccessMessageBottom;
    }

    public List<WebElement> getFooterMenuList() {
        return footerMenuList;
    }

    public WebElement getEmailErrorMessageBottom() {
        return emailErrorMessageBottom;
    }
}
