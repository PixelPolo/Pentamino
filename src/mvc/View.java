package mvc;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JPanel implements Observer, Runnable {

    // ***** FIELDS *****

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static final Color WIN_COLOR = Color.BLACK;

    private final Model model;

    private JPopupMenu jPopupMenu;
    private JMenuItem rotateRightItem;
    private JMenuItem rotateLeftItem;
    private JMenuItem flipItem;

    private final Thread thread;
    private boolean dirty;

    // ***** CONSTRUCTOR *****

    public View(Model model) {
        this.model = model;
        model.addObserver(this);
        // Panel settings
        this.setDoubleBuffered(true); // Better rendering perfs
        this.setBackground(BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // PopupMenu
        createPopupMenu();
        // Graphics adjustment
        this.setFocusable(true);
        this.requestFocusInWindow();
        // Thread launch
        thread = new Thread(this);
        thread.start();
    }

    // ***** GETTERS *****

    public JPopupMenu getjPopupMenu() {
        return jPopupMenu;
    }

    public JMenuItem getRotateRightItem() {
        return rotateRightItem;
    }

    public JMenuItem getRotateLeftItem() {
        return rotateLeftItem;
    }

    public JMenuItem getFlipItem() {
        return flipItem;
    }

    // ***** METHODS *****

    @Override
    public void run() {
        while (thread != null) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (dirty) {
                repaint();
                dirty = false;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        dirty = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        model.getBoard().display(graphics2D);
        for (int i = model.getPentaminos().size() - 1; i >= 0; i--) {
            model.getPentaminos().get(i).display(graphics2D);
        }
    }

    private void createPopupMenu() {
        jPopupMenu = new JPopupMenu();
        rotateRightItem = new JMenuItem("Rotate right");
        rotateLeftItem = new JMenuItem("Rotate left");
        flipItem = new JMenuItem("Flip");
        jPopupMenu.add(rotateRightItem);
        jPopupMenu.add(rotateLeftItem);
        jPopupMenu.add(flipItem);
        this.add(jPopupMenu);
    }
}
