package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Drivers;
@CucumberOptions(
        features = {"src/test/resources/featureFiles/SocialMediaButtonFunctionality.feature"},
        glue = {"stepDefinitions", "utils"},

        monochrome = true,

        plugin = {
                "pretty",
                "html:target/HTMLReports",
                "json:target/JSONReports/report.json",
                "junit:target/JUnitReports/report.xml"
                 }


)
public class SocialMediaButtonFunctionalityRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser", "language"})
    public void initiate(String browser, String language) {
        Drivers.threadBrowserName.set(browser);
        Drivers.threadLanguage.set(language);
    }
}
