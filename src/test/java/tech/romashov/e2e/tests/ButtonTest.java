package tech.romashov.e2e.tests;

import org.junit.Test;

public abstract class ButtonTest {
    public abstract void setUp() throws Throwable;
    @Test public abstract void clickOnButton_labelShouldBeDisplayed() throws Exception;
}
