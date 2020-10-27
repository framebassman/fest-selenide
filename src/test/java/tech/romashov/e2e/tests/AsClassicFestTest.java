package tech.romashov.e2e.tests;

import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.App;
import tech.romashov.ContentPaneReplace;

public class AsClassicFestTest extends FestSwingTestCaseTemplate {
    private FrameFixture applicationFrame;
    private static EmergencyAbortListener mEmergencyAbortListener;
    private Logger logger = LoggerFactory.getLogger(ButtonTest.class);

    @Before
//    @Override
    public void setUp() {
        logger.info("start AsClassicFestTest.setUp");
        mEmergencyAbortListener = EmergencyAbortListener.registerInToolkit();
        setUpRobot();
        ApplicationLauncher.application( App.class ).start();
        applicationFrame = WindowFinder.findFrame( ContentPaneReplace.class ).using( robot() );
    }

    @After
    public void tearDown() {
        mEmergencyAbortListener.unregister();
        cleanUp();
    }

    @Test
    public void clickOnButton_labelShouldBeDisplayed() {
        logger.info("start AsClassicFestTest.clickOnButton_labelShouldBeDisplayed");
        applicationFrame.button( "TestButton" ).click();
        applicationFrame.label("LogLabel")
                .requireEnabled()
                .requireText("Button was clicked");
    }
}
