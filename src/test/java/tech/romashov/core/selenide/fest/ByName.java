package tech.romashov.core.selenide.fest;

import org.fest.swing.core.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.awt.Component;

public class ByName extends By.ByName {
    private Robot robot;
    private String name;

    public ByName(String name, Robot robot) {
        super(name);
        this.name = name;
        this.robot = robot;
    }

    @Override
    public WebElement findElement(SearchContext context) {
        Component component = robot.finder().findByName(name);

        return null;
    }
}
