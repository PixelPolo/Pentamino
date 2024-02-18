package mvc;

import geometry.Point;
import geometry.Vector;
import shapes.pentamino.MatrixShape;
import shapes.pentamino.Pentamino;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {

    // ***** FIELDS *****

    private final Model model;
    private final View view;

    // ***** CONSTRUCTOR *****

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // Action Listener
        ActionListener actionListener = new LocalActionListener();
        view.getRotateRightItem().addActionListener(actionListener);
        view.getRotateLeftItem().addActionListener(actionListener);
        view.getFlipItem().addActionListener(actionListener);
        // Mouse listener
        MouseAdapter mouseAdapter = new LocalMouseListener();
        view.addMouseListener(mouseAdapter);
        view.addMouseMotionListener(mouseAdapter);

    }

    // TODO CHECK WIN

    // ***** ACTION LISTENER FOR POPUPMENU *****

    private class LocalActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getRotateRightItem()) model.rotateRightPentamino();
            else if (e.getSource() == view.getRotateLeftItem()) model.rotateLeftPentamino();
            else if (e.getSource() == view.getFlipItem()) model.flipPentamino();
        }
    }

    // ***** MOUSE LISTENER FOR TRANSLATION AND ROTATION *****

    private class LocalMouseListener extends MouseAdapter {
        private Pentamino selectedPentamino;
        private Point mousePosOnClick;

        @Override
        public void mousePressed(MouseEvent e) {
            mousePosOnClick = new Point(e.getX(), e.getY());
            for (Pentamino pentamino : model.getPentaminos()) {
                if (pentamino.contains(mousePosOnClick)) {
                    selectedPentamino = pentamino;
                    model.putPentaminoAtFront(pentamino);
                    if (e.isPopupTrigger()) {
                        JPopupMenu popupMenu = view.getjPopupMenu();
                        popupMenu.show(view, (int) mousePosOnClick.getX(), (int) mousePosOnClick.getY());
                    }
                    break;
                } else {
                    selectedPentamino = null;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selectedPentamino != null) {
                // Translating the piece
                int dx = 0;
                int dy = 0;
                int step = MatrixShape.TILE_WIDTH;
                dx += (int) (e.getX() - mousePosOnClick.getX());
                dy += (int) (e.getY() - mousePosOnClick.getY());
                if (Math.abs(dx) > step || Math.abs(dy) > step) {
                    int dxAligned = (dx / step) * step;
                    int dyAligned = (dy / step) * step;
                    Vector vector = new Vector(dxAligned, dyAligned);
                    model.translatePentamino(vector);
                    mousePosOnClick = new Point(
                            (int) (mousePosOnClick.getX() + dxAligned),
                            (int) (mousePosOnClick.getY() + dyAligned)
                    );
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

    }

}