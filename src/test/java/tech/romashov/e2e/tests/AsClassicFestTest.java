package tech.romashov.e2e.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.romashov.core.fest.FestTestTemplate;

public class AsClassicFestTest extends ButtonTest {
    private FestTestTemplate festTestTemplate;

    @Override
    @Before
    public void setUp() throws Throwable {
        logger.info("start AsClassicFestTest.setUp");
        festTestTemplate = new FestTestTemplate();
    }

    @Override
    @After
    public void tearDown() throws Throwable {
        festTestTemplate.close();
    }

    @Override
    @Test
    public void clickOnButton_labelShouldBeDisplayed() {
        logger.info("start AsClassicFestTest.clickOnButton_labelShouldBeDisplayed");
        festTestTemplate.fixture().button( "TestButton" ).click();
        festTestTemplate.fixture().label("LogLabel")
                .requireEnabled()
                .requireText("Button was clicked");
    }
}
