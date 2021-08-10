package tech.romashov.core.selenide;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import tech.romashov.core.selenide.marathon.MarathonDriverProvider;

public class SelenideCreator {
    public static SelenideDriver create(String mainFrameSize) {
        SelenideConfig configuration = new SelenideConfig();
        configuration.browserSize(mainFrameSize);
        configuration.browser(MarathonDriverProvider.class.getName());
        SelenideDriver driver = new SelenideDriver(configuration);
        driver.open();
        return driver;
    }
}
