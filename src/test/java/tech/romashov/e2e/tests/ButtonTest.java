package tech.romashov.e2e.tests;

import org.junit.Test;

public interface ButtonTest {
    void setUp() throws Throwable;
    @Test void clickOnButton_labelShouldBeDisplayed() throws Exception;
}
