package tech.romashov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.configuration.Environment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        int x = ThreadLocalRandom.current().nextInt(0, 300 + 1);
        int y = ThreadLocalRandom.current().nextInt(0, 300 + 1);
        this.setLocation(x, y);
        if (environment == Environment.Development || environment == Environment.Production) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        // Создание панели с двумя кнопками
        JPanel contents = new JPanel();
        JLabel logLabel = new JLabel();
        JButton button = new JButton("Button");
        button.setName("TestButton");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                logLabel.setText("Button was clicked");
                logLabel.setName("LogLabel");
            }
        });

        contents.add(button);
        contents.add(logLabel);

        // Замена панели содержимого
        setContentPane(contents);

        // Определение размера окна
        setSize(200, 100);
        // Открытие окна
        setVisible(true);
        setAlwaysOnTop(true);
    }
}
