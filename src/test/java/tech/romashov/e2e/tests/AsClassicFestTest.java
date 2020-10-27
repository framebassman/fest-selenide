package tech.romashov.e2e.tests;

import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.romashov.App;
import tech.romashov.ContentPaneReplace;

public class AsClassicFestTest extends FestSwingTestCaseTemplate {
    private FrameFixture applicationFrame;
    private static EmergencyAbortListener mEmergencyAbortListener;

    @Before
    public void setUp() {
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
    public void testJTextField() {
        applicationFrame.button( "TestButton" ).click();
        applicationFrame.label("LogLabel")
                .requireEnabled()
                .requireText("Button was clicked");
    }
}
