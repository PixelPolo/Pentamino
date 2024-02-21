package shapes.pentamino;

import geometry.Point;
import mvc.View;

import java.awt.*;
import java.util.ArrayList;

public class Board extends MatrixShape {

    // ***** FIELDS *****

    private int rows;
    private int cols;

    // ***** CONSTRUCTOR *****

    public Board(Color color, Point position) {
        this(color, position, new int[5][12]);
        rows = 5;
        cols = 12;
    }

    private Board(Color color, Point position, int[][] matrix) {
        super(color, position, matrix);
    }

    // ***** GETTERS *****

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    // ***** METHODS *****

    // TODO IMPROVE ALGORITHM RUNTIME

    public boolean boardContainsPentamino(Pentamino pentamino) {
        int n = pentamino.getMatrix().length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (pentamino.getMatrix()[row][col] == 1) {
                    // Get the coordinates of the colored parts ...
                    int x = (int) (pentamino.getPosition().getX() + col * View.TILE_WIDTH + View.TILE_WIDTH / 2);
                    int y = (int) (pentamino.getPosition().getY() + row * View.TILE_WIDTH + View.TILE_WIDTH / 2);
                    // Check if the colored parts are inside the board
                    if (!this.contains(new Point(x, y))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void addPentamino(ArrayList<Pentamino> pentaminos) {
        resetBoard();
        for (Pentamino pentamino : pentaminos) {
            if (boardContainsPentamino(pentamino)) {
                int n = pentamino.getMatrix().length;
                int deltaX = (int) ((pentamino.getPosition().getX() - getPosition().getX()) / View.TILE_WIDTH);
                int deltaY = (int) ((pentamino.getPosition().getY() - getPosition().getY()) / View.TILE_WIDTH);
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        if (pentamino.getMatrix()[row][col] == 1) {
                            getMatrix()[deltaY + row][deltaX + col] += 1;
                        }
                    }
                }
            }
        }
        System.out.println(this);
    }

    public void resetBoard() {
        setMatrix(new int[rows][cols]);
    }

}