import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainPanel panel;
    ClickListener clickListener;

    public MainFrame() {
        int PANEL_WIDTH = 1244;
        int PANEL_HEIGHT = 750;

        this.panel = new MainPanel(PANEL_WIDTH, PANEL_HEIGHT);
        this.panel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        this.clickListener = new ClickListener(this.panel);
        this.panel.addMouseListener(this.clickListener);

        this.add(this.panel);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        }
    }
