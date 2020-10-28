package tech.romashov.e2e;

import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import tech.romashov.App;
import tech.romashov.ContentPaneReplace;

public class FestTestTemplate extends FestSwingTestCaseTemplate implements AutoCloseable {
    private FrameFixture applicationFrame;
    private static EmergencyAbortListener mEmergencyAbortListener;

    public FestTestTemplate() {
        mEmergencyAbortListener = EmergencyAbortListener.registerInToolkit();
        setUpRobot();
        ApplicationLauncher.application( App.class ).start();
        applicationFrame = WindowFinder.findFrame( ContentPaneReplace.class ).using( robot() );
    }

    @Override
    public void close() throws Exception {
        mEmergencyAbortListener.unregister();
        cleanUp();
    }

    public FrameFixture fixture() {
        return applicationFrame;
    }
}
