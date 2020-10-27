package tech.romashov.e2e;

import org.junit.Test;

public abstract class ButtonTest {
    public abstract void setUp() throws Throwable;
    @Test public abstract void clickOnButton_labelShouldBeDisplayed() throws Exception;
}
