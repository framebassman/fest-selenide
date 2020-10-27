package tech.romashov.e2e.tests;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.junit.Ignore;
import org.junit.Test;
import tech.romashov.core.selenide.FestDriverProvider;

public class ViaSelenide implements ButtonTest {
    private SelenideDriver selenide;

    @Override
    public void setUp() throws Throwable {
        SelenideConfig configuration = new SelenideConfig();
        configuration.browser(FestDriverProvider.class.getName());
        selenide = new SelenideDriver(configuration);
    }

    @Override
    @Ignore
    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Exception {
        throw new UnsupportedOperationException("this test is not ready yet");
    }
}
