package tech.romashov.e2e.tests;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.fest.swing.core.BasicRobot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import tech.romashov.core.selenide.fest.FestDriver;
import tech.romashov.core.selenide.fest.FestDriverProvider;
import tech.romashov.e2e.application.AppLoader;

public class ViaSelenide extends ButtonTest {
    private SelenideDriver selenide;
    private AppLoader loader;

    @Override
    @Before
    public void setUp() throws Throwable {
        SelenideConfig configuration = new SelenideConfig();
        configuration.browser(FestDriverProvider.class.getName());
        selenide = new SelenideDriver(configuration);
    }

    @Override
    @After
    public void tearDown() throws Throwable {
        loader.close();
    }

    @Override
    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Throwable {
        logger.info("this test is not ready yet");
        selenide.open();
        loader = new AppLoader(((FestDriver) selenide.getWebDriver()).getRobot());
        selenide.$(By.name("TestButton")).click();
        throw new UnsupportedOperationException("this test is not ready yet");
    }
}
