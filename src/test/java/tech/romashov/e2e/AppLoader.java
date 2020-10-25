package tech.romashov.e2e;

import tech.romashov.App;

import javax.swing.SwingUtilities;
import java.awt.Window;

public class AppLoader implements AutoCloseable {
    public AppLoader() {
        SwingUtilities.invokeLater(() -> App.main(new String[]{""}));
    }

    @Override
    public void close() throws Exception {
//        Window win = SwingUtilities.getWindowAncestor();
//        win.dispose();
    }
}
