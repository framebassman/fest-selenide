package tech.romashov.e2e.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import tech.romashov.core.selenide.SelenideCreator;
import tech.romashov.e2e.application.AppLoader;

public class ViaSelenide extends ButtonTest {
    private SelenideDriver selenide;
    private AppLoader loader;

    @Override
    @Before
    public void setUp() throws Throwable {
        loader = new AppLoader();
        selenide = SelenideCreator.create(loader.getFrameSize());
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
