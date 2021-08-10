package tech.romashov.core.selenide;

import com.codeborne.selenide.WebDriverProvider;
import net.sourceforge.marathon.javadriver.JavaDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public class MarathonDriverProvider implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        return new JavaDriver();
    }
}
