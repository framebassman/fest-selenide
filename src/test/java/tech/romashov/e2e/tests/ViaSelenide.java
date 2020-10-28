package tech.romashov.e2e.tests;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tech.romashov.core.selenide.FestDriverProvider;

public class ViaSelenide extends ButtonTest {
    private SelenideDriver selenide;

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
        // nothing to do
    }

    @Override
    @Ignore
    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Exception {
        logger.info("this test is not ready yet");
        throw new UnsupportedOperationException("this test is not ready yet");
    }
}
