package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;

public class CheckOutPage extends Parent {
    public CheckOutPage() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement postCode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "payment_method_bacs")
    private WebElement paymentByTransfer;

    @FindBy(id = "payment_method_paypal_plus")
    private WebElement creditCardRadio;

    @FindBy(css = "[class= 'nameRow']")
    private WebElement paymentMethods;

    @FindBy(id = "terms")
    private WebElement termsAndConditions;

    @FindBy(id = "place_order")
    private WebElement placeOrder;

    @FindBy(xpath = "(//div[@class='alert_wrapper'])[2]")
    private WebElement errorMessage;

    @FindBy(className = "showcoupon")
    private WebElement showCoupon;

    @FindBy(id = "coupon_code")
    private WebElement couponCodeInput;

    @FindBy(xpath = "//div[contains(text(),'Der Gutschein')]")
    private WebElement couponErrorMessage;

    @FindBy(name = "apply_coupon")
    private WebElement applyCoupon;

    @FindBy(css = "div#ppplus>iframe")
    private WebElement iFrame;

    @FindBy(xpath = "//iframe[contains(@id,\"iframe\")]")
    private WebElement cardIframe;

    public WebElement getCardIframe() {
        return cardIframe;
    }

    public WebElement getiFrame() {
        return iFrame;
    }

    @FindBy(css = "div[data-pm=\"PayPal\"]")
    private WebElement payPalCard;

    @FindBy(css = "div[data-pm=\"Credit_Card\"]")
    private WebElement crediCard;

    @FindBy(css = "div[data-pm=\"Bank\"]")
    private WebElement bankCard;

    @FindBy(css = "div[class=\"paymentMethodRow row selected\"]")
    private WebElement uyari;

    @FindBy(css = "div[class=\"payment_box payment_method_paypal_plus\"]")
    private WebElement uyari2;

    public WebElement getUyari2() {
        return uyari2;
    }

    public WebElement getUyari() {
        return uyari;
    }

    public WebElement getBankCard() {
        return bankCard;
    }

    public WebElement getPayPalCard() {
        return payPalCard;
    }

    public WebElement getCrediCard() {
        return crediCard;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPaymentByTransfer() {
        return paymentByTransfer;
    }

    public WebElement getCreditCardRadio() {
        return creditCardRadio;
    }

    public WebElement getPaymentMethods() {
        return paymentMethods;
    }

    public WebElement getTermsAndConditions() {
        return termsAndConditions;
    }

    public WebElement getPlaceOrder() {
        return placeOrder;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getShowCoupon() {
        return showCoupon;
    }

    public WebElement getCouponCodeInput() {
        return couponCodeInput;
    }

    public WebElement getCouponErrorMessage() {
        return couponErrorMessage;
    }

    public WebElement getApplyCoupon() {
        return applyCoupon;
    }
}
