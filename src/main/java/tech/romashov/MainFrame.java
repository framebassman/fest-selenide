package tech.romashov;

import com.codebrig.journey.JourneyBrowserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.configuration.Environment;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.concurrent.ThreadLocalRandom;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(MainFrame.class);
    private Environment environment;

    public MainFrame(Environment environment) {
        super("Title");
        logger.info("Current environment: {}", environment);
        this.environment = environment;
        initFrame();
    }

    private void initFrame() {
        this.setName("MainFrame");
        this.setLocation(
                ThreadLocalRandom.current().nextInt(0, 300 + 1),
                ThreadLocalRandom.current().nextInt(0, 300 + 1)
        );
        if (environment == Environment.Development || environment == Environment.Production) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        JourneyBrowserView browser = new JourneyBrowserView("https://google.com");
        getContentPane().add(browser, BorderLayout.CENTER);
        setVisible(true);
        setSize(200, 100);
    }
}
