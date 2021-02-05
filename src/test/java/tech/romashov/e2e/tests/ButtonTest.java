package tech.romashov.e2e.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ButtonTest {
    protected Logger logger = LoggerFactory.getLogger(ButtonTest.class);
    public abstract void setUp() throws Throwable;
    public abstract void tearDown() throws Throwable;
    public abstract void clickOnButton_labelShouldBeDisplayed() throws Throwable;
}
