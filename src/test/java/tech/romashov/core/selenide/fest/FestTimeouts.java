package tech.romashov.core.selenide.fest;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FestTimeouts implements WebDriver.Timeouts {
    @Override
    public WebDriver.Timeouts implicitlyWait(long time, TimeUnit unit) {
        return null;
    }

    @Override
    public WebDriver.Timeouts setScriptTimeout(long time, TimeUnit unit) {
        return null;
    }

    @Override
    public WebDriver.Timeouts pageLoadTimeout(long time, TimeUnit unit) {
        return null;
    }
}
