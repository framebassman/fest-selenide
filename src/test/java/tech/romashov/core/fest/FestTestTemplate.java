package tech.romashov.core.fest;

import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import tech.romashov.App;
import tech.romashov.MainFrame;
import tech.romashov.configuration.Environment;

public class FestTestTemplate extends FestSwingTestCaseTemplate implements AutoCloseable {
    private FrameFixture applicationFrame;
    private static EmergencyAbortListener mEmergencyAbortListener;

    public FestTestTemplate() {
        mEmergencyAbortListener = EmergencyAbortListener.registerInToolkit();
        setUpRobot();
        ApplicationLauncher.application( App.class ).withArgs(Environment.Test.toString()).start();
        applicationFrame = WindowFinder.findFrame( MainFrame.class ).using( robot() );
    }

    @Override
    public void close() throws Exception {
        applicationFrame.close();
        mEmergencyAbortListener.unregister();
        cleanUp();
    }

    public FrameFixture fixture() {
        return applicationFrame;
    }
}
