package mvc;

import shapes.pentamino.Board;
import shapes.pentamino.MatrixShape;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JPanel implements Observer, Runnable {

    // ***** FIELDS *****

    public static final int TILE_WIDTH = 40;
    public static final int WIDTH = 24 * View.TILE_WIDTH;
    public static final int HEIGHT = 17 * View.TILE_WIDTH;
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static final Color WIN_COLOR = Color.BLACK;

    private final Model model;

    private JButton boardOne;
    private JButton boardTwo;
    private JButton boardThree;
    private JButton boardFour;

    private JPopupMenu jPopupMenu;
    private JMenuItem rotateRightItem;
    private JMenuItem rotateLeftItem;
    private JMenuItem flipHorItem;
    private JMenuItem flipVerItem;

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
        // Buttons and PopupMenu
        createBtn();
        createPopupMenu();
        // Graphics adjustment
        this.setFocusable(true);
        this.requestFocusInWindow();
        // Thread launch
        thread = new Thread(this);
        thread.start();
    }

    // ***** GETTERS *****

    public JButton getBoardOne() {
        return boardOne;
    }

    public JButton getBoardTwo() {
        return boardTwo;
    }

    public JButton getBoardThree() {
        return boardThree;
    }

    public JButton getBoardFour() {
        return boardFour;
    }

    public JPopupMenu getjPopupMenu() {
        return jPopupMenu;
    }

    public JMenuItem getRotateRightItem() {
        return rotateRightItem;
    }

    public JMenuItem getRotateLeftItem() {
        return rotateLeftItem;
    }

    public JMenuItem getFlipHorItem() {
        return flipHorItem;
    }

    public JMenuItem getFlipVerItem() {
        return flipVerItem;
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

    private void createBtn() {
        boardOne = new JButton("06 x 10");
        boardTwo = new JButton("05 x 12");
        boardThree = new JButton("04 x 15");
        boardFour = new JButton("3 x 20");
        this.add(boardOne);
        this.add(boardTwo);
        this.add(boardThree);
        this.add(boardFour);
    }

    private void createPopupMenu() {
        jPopupMenu = new JPopupMenu();
        rotateRightItem = new JMenuItem("Rotate right");
        rotateLeftItem = new JMenuItem("Rotate left");
        flipHorItem = new JMenuItem("Flip horizontally");
        flipVerItem = new JMenuItem("Flip vertically");
        jPopupMenu.add(rotateRightItem);
        jPopupMenu.add(rotateLeftItem);
        jPopupMenu.add(flipHorItem);
        jPopupMenu.add(flipVerItem);
        this.add(jPopupMenu);
    }

}