package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import utils.Drivers;

import java.time.Duration;
import java.util.Random;

public class ProductFunctionality {

    private int randomNumberOfProduct;
    private String numberOfProduct;
    private final ProductPage product;
    private final HomePage homePage;
    private final BlogPage blogPage;
    private final CartPage cart;
    private final Actions action;
    private final WebDriverWait wait;
    private final Random randomNumber;
    private String numberOfStocks;
    private Action action1;
    private String expectedWarning;
    private String actualWarning;

    public ProductFunctionality(ProductPage product, HomePage homePage, CartPage cart, BlogPage blogPage) {
        this.product = product;
        this.blogPage = blogPage;
        this.homePage = homePage;
        this.cart = cart;
        action = new Actions(Drivers.getDriver());
        wait = new WebDriverWait(Drivers.getDriver(), Duration.ofSeconds(10));
        randomNumber = new Random();
    }

    @Given("^Hover over the Product Button$")
    public void hover_over_the_Product_Button() {
        if (Drivers.threadLanguage.get().equals("DE")) {
            homePage.hoverOverRandomlyOnAnElement(homePage.getProductBtn());
        } else {
            homePage.clickToElement(homePage.getProductBtn());
        }
    }

    @Then("^User should be able to see the sub menus of the Product page$")
    public void userShouldBeAbleToSeeTheSubMenusOfTheProductPage() {
        if (Drivers.threadLanguage.get().equals("DE")) {
            boolean submenuEnabled = homePage.getProductSubMenu().isEnabled();
            Assert.assertTrue(submenuEnabled);
        }
    }

    @Then("^Click on the sub menus of the Product Button$")
    public void click_on_the_sub_menus_of_the_Product_Button() {
        if (Drivers.threadLanguage.get().equals("DE")) {
            for (int i = 0; i < homePage.getProductSubMenuList().size(); i++) {
                homePage.hoverOverRandomlyOnAnElement(homePage.getProductBtn());
                homePage.getProductSubMenuList().get(i).click();
                String url = homePage.getProductSubMenuList().get(i).getAttribute("href");
                homePage.assertUrl(url);
            }
        }
    }

    @And("^Click on one of the products randomly which is in the stocks$")
    public void clickOnOneOfTheProductsRandomlyWhichIsInTheStocks() {
        product.clickRandomlyFromAList(product.getProductListInStcok());
    }

    @When("^Click on the Warenkorb button$")
    public void clickOnTheWarenkorbButton() {
        numberOfStocks = product.getStockNumber().getText().replaceAll("[^0-9]", "");//stok sayisi
        product.clickToElement(product.getAddToCart());
    }

    @Then("^The product should have been added to the cart$")
    public void theProductShouldHaveBeenAddedToTheCart() {
        product.assertMessage(product.getUpdatedSuccessMessage(), "wurde deinem Warenkorb hinzugefügt");
    }

    @And("^Before the user can add the product to the cart, the product quantity must be changed according to the stock quantity$")
    public void beforeTheUserCanAddTheProductToTheCartTheProductQuantityMustBeChangedAccordingToTheStockQuantity() {
        numberOfStocks = product.getStockNumber().getText().replaceAll("[^0-9]", "");
        randomNumberOfProduct = (randomNumber.nextInt(Integer.parseInt(numberOfStocks))) + 1;
        if (numberOfStocks.equals("1")) {
            product.clickToElement(product.getAddToCart());
        } else if (Integer.parseInt(numberOfStocks) > 1 && randomNumberOfProduct == 1) {
            randomNumberOfProduct += 1;
            numberOfProduct = String.valueOf(randomNumberOfProduct);
            product.sendKeys(product.getInputProductQuantity(), "randomNumberOfProduct");
        } else
            numberOfProduct = String.valueOf(randomNumberOfProduct);
        product.sendKeys(product.getInputProductQuantity(), numberOfProduct);
    }

    @Then("^The correct number of the products should have been added to the cart$")
    public void theCorrectNumberOfTheProductsShouldHaveBeenAddedToTheCart() {
        Assert.assertEquals(product.getInputProductQuantity().getAttribute("value"), numberOfProduct);
    }

    @And("^After the user adds the product to the cart, the product quantity should be changed according to the stock amount$")
    public void afterTheUserAddsTheProductToTheCartTheProductQuantityShouldBeChangedAccordingToTheStockAmount() {
        randomNumberOfProduct = (randomNumber.nextInt(Integer.parseInt(numberOfStocks))) + 1; // stok sayisina gore random sayi
        if (numberOfStocks.equals("1")) {

        } else if (Integer.parseInt(numberOfStocks) > 1 && randomNumberOfProduct == 1) {
            randomNumberOfProduct += 1;
            numberOfProduct = String.valueOf(randomNumberOfProduct);
            product.sendKeys(product.getInputProductQuantity(), "randomNumberOfProduct");
        } else
            numberOfProduct = String.valueOf(randomNumberOfProduct);
        product.sendKeys(product.getInputProductQuantity(), numberOfProduct);
    }

    @When("^Click on the Warenkorb Aktualisieren button$")
    public void clickOnTheWarenkorbAktualisierenButton() {
        cart.clickToElement(cart.getIconCancelBtn());
        cart.clickToElement(cart.getUpdateShoppingCartBtn());
    }

    @Then("^The user should be able to update the cart$")
    public void theUserShouldBeAbleToUpdateTheCart() {
        wait.until(ExpectedConditions.invisibilityOf(product.getUpdatedSuccessMessage()));
        product.assertMessage(product.getUpdatedSuccessMessage(), "Warenkorb aktualisiert");
    }

    @When("^Click on the delete X button$")
    public void clickOnTheDeleteXButton() {
        cart.waitUntilVisible(cart.getProductDeleteBtn());
        cart.clickToElement(cart.getProductDeleteBtn());
    }

    @Then("^The user should be able to delete the product from the cart$")
    public void theUserShouldBeAbleToDeleteTheProductFromTheCart() {
        cart.assertMessage(cart.getDeletedMessage(), "Dein Warenkorb ist gegenwärtig leer.");
        cart.assertMessage(product.getUpdatedSuccessMessage(), "entfernt");
    }

    @And("^Hover over one of the product images at random$")
    public void hoverOverOneOfTheProductsImageAtRandom() {
        randomNumberOfProduct = product.randomIndexForLists(blogPage.getImageList());
        action.moveToElement(blogPage.getImageList().get(randomNumberOfProduct)).perform();
    }

    @When("^Click on the product link button$")
    public void clickOnTheProductLinkButton() {
        action.moveByOffset(100, 100).click().perform();
    }

    @Then("^The user should be able to see the product details$")
    public void theUserShouldBeAbleToSeeTheProductDetails() {
        Assert.assertTrue(product.getProductDescription().isDisplayed());
    }

    @And("^Hover over one of the products image randomly which is in the stocks$")
    public void hoverOverOneOfTheProductsImageRandomlyWhichIsInTheStocks() throws InterruptedException {
        if (!Drivers.threadLanguage.get().equals("DE")) {
            homePage.waitUntilVisible(homePage.getCookiesAccept());
            homePage.clickToElement(homePage.getCookiesAccept());
        }
        randomNumberOfProduct = product.randomIndexForLists(product.getImgListInStock());
        action.moveToElement(product.getImgListInStock().get(randomNumberOfProduct)).perform();

    }

    @When("^Click on the Cart icon$")
    public void clickOnTheCartIcon() throws InterruptedException {
        if (!Drivers.threadLanguage.get().equals("DE")) {
            wait.until(ExpectedConditions.invisibilityOf(homePage.getCookiesAccept()));
        }
        action.moveByOffset(-100, 100).click().perform();
    }

    @When("^Click on the Rückgängig button$")
    public void clickOnTheRückgängigButton() {
        cart.waitUntilVisible(cart.getRuckgangigBtn());
        cart.clickToElement(cart.getRuckgangigBtn());
    }

    @Then("^The user should be able to re add the product to the cart$")
    public void theUserShouldBeAbleToReAddTheProductToTheCart() {
        cart.waitUntilVisible(cart.getItemText());
        Assert.assertTrue(cart.getItemText().isDisplayed());
    }

    @When("^Click on the Weiter Einkaufen button$")
    public void clickOnTheWeiterEinkaufenButton() {
        cart.waitUntilVisible(cart.getWeiterEinkaufenBtn());
        cart.clickToElement(cart.getWeiterEinkaufenBtn());
    }

    @When("^Click on one of the products randomly which is in the out of stocks$")
    public void clickOnOneOfTheProductsRandomlyWhichIsInTheOutOfStocks() {
        product.clickRandomlyFromAList(product.getProductListOutOfStock());
    }

    @Then("^The out of stock message should be seen$")
    public void theOutOfStockMessageShouldBeSeen() {
        product.waitUntilVisible(product.getOutOfStockGetText());
        product.assertMessage(product.getOutOfStockGetText(), "Nicht vorrätig");
    }

    @And("^Before adding the product to the cart, the user must change the product quantity to zero or one more than the stock quantity \"([^\"]*)\"$")
    public void beforeAddingTheProductToTheCartTheUserMustChangeTheProductQuantityToZeroOrOneMoreThanTheStockQuantity(String productQuantity) {
        numberOfStocks = product.getStockNumber().getText().replaceAll("[^0-9]", "");//stok sayisi
        if (!numberOfStocks.equals("1")) {
            if (!productQuantity.equals("0")) {
                int inputNumber = Integer.parseInt(numberOfStocks) + Integer.parseInt(productQuantity);
                productQuantity = String.valueOf(inputNumber);
            }
            product.sendKeys(product.getInputProductQuantity(), productQuantity);
            expectedWarning = product.getInputProductQuantity().getAttribute("validationMessage");
        }
    }

    @Then("^The user should be able to see the warning that you cannot add more or zero products than the stock amount of the product$")
    public void theUserShouldBeAbleToSeeTheWarningThatYouCannotAddMoreOrZeroProductsThanTheStockAmountOfTheProduct() {
        if (!numberOfStocks.equals("1")) {
            actualWarning = product.getInputProductQuantity().getAttribute("validationMessage");
            Assert.assertEquals(expectedWarning, actualWarning);
        }
    }
}

