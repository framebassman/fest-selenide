package tech.romashov.e2e.application;

import org.fest.swing.core.NameMatcher;
import org.fest.swing.core.Robot;
import tech.romashov.App;
import tech.romashov.core.assertions.AssertWithTimeout;

import javax.swing.SwingUtilities;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class AppLoader {
    public AppLoader(Robot robot) throws Throwable {
        SwingUtilities.invokeLater(() -> App.main(new String[]{""}));
        AssertWithTimeout.assertThat(
                () -> {
                    System.out.println("Check TestContentPane");
                    return robot.finder().find(new NameMatcher("TestContentPane"));
                },
                not(nullValue()),
                4_000,
                300
        );
    }
}
