package tech.romashov.e2e.tests;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.e2e.application.AppLoader;

import java.awt.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AsProduction {
    private Robot robot;
    private Logger logger = LoggerFactory.getLogger(ButtonTest.class);
    private AppLoader loader;

//    @Override
    @Before
    public void setUp() throws Throwable {
        logger.info("start AsProduction.setUp");
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        loader = new AppLoader(robot);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("start AsProduction.tearDown");
        loader.close();
    }

    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Exception {
        logger.info("start AsProduction.clickOnButton_labelShouldBeDisplayed");
        Component button = robot.finder().find(new NameMatcher("TestButton"));
        robot.click(button);
        Component label = robot.finder().find(new NameMatcher("LogLabel"));
        assertThat(label.isVisible(), equalTo(true));
    }
}
