import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

    MainPanel panel;
    public ClickListener(MainPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getY() < 50 && e.getX() < 50) {
            panel.check();
        } else if (e.getX() > 389 && e.getX() < 513) {
            if (e.getY() < 163 && e.getY() > 106) {
                panel.switchImage(1);
            } else if (e.getY() < 220) {
                panel.switchImage(2);
            } else if (e.getY() < 332 && e.getY() > 277) {
                panel.switchImage(3);
            } else if (e.getY() < 387) {
                panel.switchImage(4);
            } else if (e.getY() < 444) {
                panel.switchImage(5);
            } else if (e.getY() < 501) {
                panel.switchImage(6);
            } else if (e.getY() < 560) {
                panel.switchImage(7);
            } else if (e.getY() < 615) {
                panel.switchImage(8);
            }
        } else if (e.getX() > 513) {
            panel.check();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
