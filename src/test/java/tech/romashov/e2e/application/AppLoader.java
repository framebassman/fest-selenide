package tech.romashov.e2e.application;

import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.App;
import tech.romashov.core.assertions.AssertWithTimeout;

import javax.swing.SwingUtilities;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class AppLoader implements AutoCloseable {
    private App app;

    public AppLoader(Robot robot) throws Throwable {
        Logger logger = LoggerFactory.getLogger(AppLoader.class);
        app = new App();
        SwingUtilities.invokeLater(() -> app.start());
        AssertWithTimeout.assertThat(
                () -> {
                    logger.info("Check TestContentPane");
                    return robot.finder().find(new NameMatcher("TestContentPane"));
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
}
