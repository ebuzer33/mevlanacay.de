package utils;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void before() {
        if (Drivers.threadLanguage.get() == null) {
            Drivers.threadLanguage.set("DE");
        }
        Drivers.getDriver().manage().deleteAllCookies();
        Parent.getUrl(Drivers.threadLanguage.get());
    }

    @After
    public void after() {

        Drivers.quitDriver();

    }
}
