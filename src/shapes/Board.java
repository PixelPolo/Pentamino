package shapes;

import geometry.Angle;
import geometry.Point;

import java.awt.*;

public class Board extends MatrixShape {

    // TESTS
    public static void main(String[] args) {
        Board board = new Board(Color.BLUE, new Point(0, 0));
        System.out.println(board);
    }

    private static int[][] initMatrix() {
        return new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public Board(Color color, Point position) {
        this(color, position, initMatrix());
    }

    private Board(Color color, Point position, int[][] matrix) {
        super(color, position, matrix);
    }

}