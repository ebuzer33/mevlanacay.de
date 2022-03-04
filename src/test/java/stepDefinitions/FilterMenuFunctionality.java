package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.ProductPage;
import utils.Drivers;
import java.util.List;

public class FilterMenuFunctionality {
    private final ProductPage product;

    public FilterMenuFunctionality(ProductPage product) {
        this.product = product;
    }

    @Then("^Click to the Teezubehör Button$")
    public void clickToTheTeezubehörButton() {
        if(Drivers.threadLanguage.get().equals("DE")) {
            product.getTeezubehörBtn().click();
        }
    }

    @And("^Click on the filter button$")
    public void clickOnTheFilterButton() {
        product.getFilterBtn().click();
    }

    @Then("^Click on the filtering type$")
    public void clickOnTheFilteringType(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (String s : listElement) {
            Select menu = new Select(product.getFilterMenu());
            menu.selectByValue(s);
            product.getFilterBtn().click();
            product.assertUrl(s);
        }
    }
}
