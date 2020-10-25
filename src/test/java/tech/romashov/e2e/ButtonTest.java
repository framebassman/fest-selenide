package tech.romashov.e2e;

import org.fest.swing.finder.WindowFinder;
import org.fest.swing.launcher.ApplicationLauncher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import tech.romashov.App;
import tech.romashov.ContentPaneReplace;

public class ButtonTest extends FestSwingTestCaseTemplate {
    private FrameFixture mFrame;

    @Before
    public void buttonTestSetup() {
        setUpRobot();
        ApplicationLauncher.application( App.class ).start();
        mFrame = WindowFinder.findFrame( ContentPaneReplace.class ).using( robot() );
    }

    @After
    public void tearDown(){
        cleanUp();
    }

    @Test
    public void ClickOnButton() throws Exception {
        mFrame.button( "TestButton" ).click();
        mFrame.label("LogLabel").requireVisible();
    }
}
