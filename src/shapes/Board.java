package shapes;

import java.awt.*;

public class Board extends MatrixShape {

    // TESTS
    public static void main(String[] args) {
        Board board = new Board(Color.BLUE);
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

    public Board(Color color) {
        this(color, initMatrix());
    }

    protected Board(Color color, int[][] matrix) {
        super(color, matrix);
    }

}