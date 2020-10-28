package tech.romashov.e2e.tests;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.e2e.FestTestTemplate;

public class AsClassicFestTest extends ButtonTest {
    private Logger logger = LoggerFactory.getLogger(ButtonTest.class);
    private FestTestTemplate festTestTemplate;

    @Before
    @Override
    public void setUp() {
        logger.info("start AsClassicFestTest.setUp");
        festTestTemplate = new FestTestTemplate();
    }

    @After
    public void tearDown() throws Exception {
        festTestTemplate.close();
    }

    @Override
    public void clickOnButton_labelShouldBeDisplayed() {
        logger.info("start AsClassicFestTest.clickOnButton_labelShouldBeDisplayed");
        festTestTemplate.fixture().button( "TestButton" ).click();
        festTestTemplate.fixture().label("LogLabel")
                .requireEnabled()
                .requireText("Button was clicked");
    }
}
