package tech.romashov.core.selenide.fest;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Component;
import java.util.List;
import java.util.Set;

public class FestDriver implements WebDriver {
    private Options options;
    private Robot robot;

    public FestDriver() {
        options = new FestOptions();
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
    }

    public Robot getRobot() {
        return robot;
    }

    @Override
    public void get(String url) {
        int a = 1;
    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return options;
    }
}
