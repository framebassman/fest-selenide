package tech.romashov.e2e;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.junit.Before;
import org.junit.Test;
import tech.romashov.core.selenide.FestDriverProvider;

import java.awt.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ButtonTest {
    private Robot robot;
    private SelenideDriver selenide;

    @Before
    public void buttonTestSetup() throws Throwable {
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        new AppLoader(robot);
        SelenideConfig configuration = new SelenideConfig();
        configuration.browser(FestDriverProvider.class.getName());
        selenide = new SelenideDriver(configuration);
    }

    @Test
    public void ClickOnButton() throws Exception {
        Component button = robot.finder().find(new NameMatcher("TestButton"));
        robot.click(button);
        Component label = robot.finder().find(new NameMatcher("LogLabel"));
        assertThat(label.isVisible(), equalTo(true));
    }
}
