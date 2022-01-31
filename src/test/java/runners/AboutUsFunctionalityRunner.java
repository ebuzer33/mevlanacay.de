package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Drivers;

@CucumberOptions(
        features = {"src/test/resources/featureFiles/AboutUsFunctionality.feature"},
        glue = {"stepDefinitions", "utils"}

)
public class AboutUsFunctionalityRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser", "language"})
    public void initiate(String browser, String language) {
        Drivers.threadBrowserName.set(browser);
        Drivers.threadLanguage.set(language);
    }
}


