package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FooterMenuFunctionality {
    private final HomePage homePage;

    public FooterMenuFunctionality(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^Hover over the buttons in the footer menu$")
    public void hover_over_the_buttons_in_the_footer_menu() {

        for (WebElement element : homePage.getFooterMenuList()) {

            String beforeBackgroundColor = element.getCssValue("background-color");
            homePage.hoverOverRandomlyOnAnElement(element);

            String afterBackgroundColor = element.getCssValue("background-color");
            Assert.assertNotEquals(beforeBackgroundColor, afterBackgroundColor);
        }
    }

    @Then("^Footer menu links should work properly$")
    public void footerMenuLinksShouldWorkProperly() {
        String url;
        HttpURLConnection huc;
        int respCode;

        for (WebElement element : homePage.getFooterMenuList()) {
            // We took the href of the anchor tag and stored it in the url variable.
            url = element.getAttribute("href");
            // We checked if the URL is null or Empty.
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
            } else {
                try {

                    // HttpURLConnection class has methods to send HTTP request and capture HTTP response code.
                    // So, output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
                    huc = (HttpURLConnection) (new URL(url).openConnection());

                    // When the connect() method is called, the actual connection is established with the url
                    // and the request is sent.
                    huc.connect();

                    // We get the response code for the request using the getResponseCode() method.
                    respCode = huc.getResponseCode();

                    // We check the link status
                    if (respCode >= 400) {
                        System.out.println(url + " is a broken link");
                    } else {
                        System.out.println(url + " is a valid link");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

