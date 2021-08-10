package tech.romashov.e2e.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.fest.swing.core.NameMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import tech.romashov.App;
import tech.romashov.configuration.Environment;
import tech.romashov.core.selenide.MarathonDriverProvider;
import tech.romashov.e2e.application.AppLoader;

import javax.swing.SwingUtilities;

import java.awt.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class ViaSelenide extends ButtonTest {
    private SelenideDriver selenide;
    private AppLoader loader;

    @Override
    @Before
    public void setUp() throws Throwable {
        SelenideConfig configuration = new SelenideConfig();
        configuration.browser(MarathonDriverProvider.class.getName());
        selenide = new SelenideDriver(configuration);
        loader = new AppLoader();
        selenide.open();
    }

    @Override
    @After
    public void tearDown() throws Throwable {
        selenide.close();
        loader.close();
    }

    @Override
    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Throwable {
        logger.info("start ViaSelenide.clickOnButton_labelShouldBeDisplayed");
        selenide.find(By.name("TestButton")).click();
        selenide.find(By.name("LogLabel")).shouldBe(Condition.visible);
    }
}
