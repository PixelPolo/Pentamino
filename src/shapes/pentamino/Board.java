package shapes.pentamino;

import geometry.Point;

import java.awt.*;

public class Board extends MatrixShape {

    private static int[][] initMatrix() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    // ***** CONSTRUCTOR *****

    public Board(Color color, Point position) {
        this(color, position, initMatrix());
    }

    private Board(Color color, Point position, int[][] matrix) {
        super(color, position, matrix);
    }

    // ***** METHODS *****

    // TODO ADD PENTAMINO TO THE BOARD FOR WIN CONDITIONS
    public void addPentamino(Pentamino pentamino) {

    }

}