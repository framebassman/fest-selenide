package tech.romashov.e2e;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Component;

public class ButtonTest {
    private Robot robot;

    @Before
    public void buttonTestSetup() {
        new AppLoader();
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
    }

    @Test
    public void ClickOnButton() throws Exception {
        Component button = robot.finder().find(new NameMatcher("TestButton"));
        robot.click(button);
        Component label = robot.finder().find(new NameMatcher("LogLabel"));
        Assert.assertTrue(label.isVisible());
    }
}
