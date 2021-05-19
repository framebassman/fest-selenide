package tech.romashov.e2e.tests;

import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.romashov.e2e.application.AppLoader;

import java.awt.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AsProduction extends ButtonTest {
    private AppLoader loader;
    private Robot robot;

    @Override
    @Before
    public void setUp() throws Throwable {
        logger.info("start AsProduction.setUp");
        loader = new AppLoader();
        robot = loader.getRobot();
    }

    @Override
    @After
    public void tearDown() throws Throwable {
        logger.info("start AsProduction.tearDown");
        loader.close();
        robot.cleanUp();
    }

    @Override
    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Exception {
        logger.info("start AsProduction.clickOnButton_labelShouldBeDisplayed");
        Component button = robot.finder().find(new NameMatcher("TestButton"));
        robot.click(button);
        Component label = robot.finder().find(new NameMatcher("LogLabel"));
        assertThat(label.isVisible(), equalTo(true));
    }
}
