package tech.romashov.e2e.tests;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.junit.Before;
import org.junit.Test;
import tech.romashov.e2e.application.AppLoader;

import java.awt.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AsProduction {
    private Robot robot;

//    @Override
    @Before
    public void setUp() throws Throwable {
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        new AppLoader(robot);
    }

    @Test
    public void clickOnButton_labelShouldBeDisplayed() throws Exception {
        Component button = robot.finder().find(new NameMatcher("TestButton"));
        robot.click(button);
        Component label = robot.finder().find(new NameMatcher("LogLabel"));
        assertThat(label.isVisible(), equalTo(true));
    }
}
