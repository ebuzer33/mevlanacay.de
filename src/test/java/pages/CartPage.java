package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;

public class CartPage extends Parent {
    public CartPage() {
        PageFactory.initElements(Drivers.getDriver(),this);
    }

    @FindBy(xpath="//td[@data-title=\"Produkt\"]/a")
    private WebElement itemText;

    @FindBy(css="div[class=\"cart-empty alert alert_warning\"] .alert_wrapper")
    private WebElement deletedMessage;

    @FindBy(css="td.product-remove")
    private WebElement productDeleteBtn;

    @FindBy(css="a.restore-item")
    private WebElement ruckgangigBtn;

    @FindBy(css="div.alert_wrapper>a")
    private WebElement weiterEinkaufenBtn;

    @FindBy(xpath="//button[@name=\"update_cart\"]")
    private WebElement updateShoppingCartBtn;

    @FindBy(xpath="//a[@class=\"checkout-button button alt wc-forward\"]")
    private WebElement checkOutBtn;

    @FindBy(xpath="(//a[@class=\"close\"])[1]")
    private WebElement iconCancelBtn;

    public WebElement getItemText() {
        return itemText;
    }

    public WebElement getDeletedMessage() {
        return deletedMessage;
    }

    public WebElement getProductDeleteBtn() {
        return productDeleteBtn;
    }

    public WebElement getRuckgangigBtn() {
        return ruckgangigBtn;
    }

    public WebElement getWeiterEinkaufenBtn() {
        return weiterEinkaufenBtn;
    }

    public WebElement getUpdateShoppingCartBtn() {
        return updateShoppingCartBtn;
    }

    public WebElement getCheckOutBtn() {
        return checkOutBtn;
    }

    public WebElement getIconCancelBtn() {
        return iconCancelBtn;
    }
}
