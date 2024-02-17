package shapes;

import geometry.Point;

import java.awt.*;

public class Pentamino extends MatrixShape {


    public static void main(String[] args) {
        Pentamino L = Pentamino.L(Color.BLUE, new Point(50, 50));
        System.out.println(L);
        L.rotateMatrixRight();
        System.out.println(L);
        L.rotateMatrixRight();
        System.out.println(L);
    }

    private static int[][] initL() {
        return new int[][] {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };
    }

    private static int[][] initI() {
        return new int[][] {
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };
    }

    public Pentamino(Color color, Point position, int[][] matrix) {
        super(color, position, matrix);
    }

    public static Pentamino L(Color color, Point position) {
        return new Pentamino(color, position, initL());
    }

    public static Pentamino I(Color color, Point position) {
        return new Pentamino(color, position, initI());
    }

}
