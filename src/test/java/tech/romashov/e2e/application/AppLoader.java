package tech.romashov.e2e.application;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.exception.ComponentLookupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.App;
import tech.romashov.configuration.Environment;
import tech.romashov.core.assertions.AssertWithTimeout;

import javax.swing.SwingUtilities;

import static org.fest.swing.core.matcher.FrameMatcher.withName;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class AppLoader implements AutoCloseable {
    private App app;
    private Robot robot;

    public AppLoader() throws Throwable {
        Logger logger = LoggerFactory.getLogger(AppLoader.class);
        app = new App();
        SwingUtilities.invokeLater(() -> app.start(Environment.Test));
        AssertWithTimeout.assertThat(
                () -> {
                    try {
                        logger.info("Check TestContentPane");
                        robot = BasicRobot.robotWithCurrentAwtHierarchy();
                        return robot.finder().find(withName("TestContentPane").andTitle("TestContentPaneTitle").andShowing());
                    } catch (ComponentLookupException exception) {
                        logger.info("Application is not ready yet");
                        logger.info(exception.getMessage(), exception);
                        return null;
                    }
                },
                not(nullValue()),
                4_000,
                300
        );
    }

    @Override
    public void close() {
        app.close();
    }

    public Robot getRobot() {
        return robot;
    }
}
