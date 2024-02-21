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
        view.getBoardOne().addActionListener(actionListener);
        view.getBoardTwo().addActionListener(actionListener);
        view.getBoardThree().addActionListener(actionListener);
        view.getBoardFour().addActionListener(actionListener);
        view.getRotateRightItem().addActionListener(actionListener);
        view.getRotateLeftItem().addActionListener(actionListener);
        view.getFlipHorItem().addActionListener(actionListener);
        view.getFlipVerItem().addActionListener(actionListener);
        // Mouse listener
        MouseAdapter mouseAdapter = new LocalMouseListener();
        view.addMouseListener(mouseAdapter);
        view.addMouseMotionListener(mouseAdapter);

    }

    // ***** METHODS *****

    private void checkWin() {
        boolean win = true;
        int boardHeight = model.getBoard().getMatrix().length;
        int boardWidth = model.getBoard().getMatrix()[0].length;
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if (model.getBoard().getMatrix()[row][col] != 1) {
                    win = false;
                    break;
                }
            }
        }
        if (win) view.setBackground(View.WIN_COLOR);
        else view.setBackground(View.BACKGROUND_COLOR);
    }

    // ***** ACTION LISTENER FOR POPUPMENU *****

    private class LocalActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getRotateRightItem()) model.rotateRightPentamino();
            else if (e.getSource() == view.getRotateLeftItem()) model.rotateLeftPentamino();
            else if (e.getSource() == view.getFlipHorItem()) model.flipPentaminoHorizontally();
            else if (e.getSource() == view.getFlipVerItem()) model.flipPentaminoVertically();
            else if (e.getSource() == view.getBoardOne()) model.modifyBoard(6, 10);
            else if (e.getSource() == view.getBoardTwo()) model.modifyBoard(5, 12);
            else if (e.getSource() == view.getBoardThree()) model.modifyBoard(4, 15);
            else if (e.getSource() == view.getBoardFour()) model.modifyBoard(3, 20);
            checkWin();
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
            checkWin();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selectedPentamino != null) {
                // Translating the piece
                int dx = 0;
                int dy = 0;
                int step = View.TILE_WIDTH;
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
            model.getBoard().addPentamino(model.getPentaminos());
            checkWin();
        }

    }

}