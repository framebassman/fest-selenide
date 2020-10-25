package tech.romashov.e2e;

import tech.romashov.App;

import javax.swing.SwingUtilities;

public class AppLoader {
    public AppLoader() {
        SwingUtilities.invokeLater(() -> App.main(new String[]{""}));
    }
}
