package shapes.pentamino;

import geometry.Point;

import java.awt.*;

// https://fr.wikipedia.org/wiki/Pentomino#/media/Fichier:Pentominos.svg

public class Pentamino extends MatrixShape {

    // ***** PRIVATE CONSTRUCTOR *****

    private Pentamino(Color color, Point position, int[][] matrix) {
        super(color, position, matrix);
    }

    // ***** F *****

    private static int[][] initF() {
        return new int[][]{
                {9, 1, 1},
                {1, 1, 9},
                {9, 1, 9}
        };
    }

    public static Pentamino F(Color color, Point position) {
        return new Pentamino(color, position, initF());
    }

    // ***** I *****

    private static int[][] initI() {
        return new int[][]{
                {9, 1, 9, 9, 9},
                {9, 1, 9, 9, 9},
                {9, 1, 9, 9, 9},
                {9, 1, 9, 9, 9},
                {9, 1, 9, 9, 9}
        };
    }

    public static Pentamino I(Color color, Point position) {
        return new Pentamino(color, position, initI());
    }

    // ***** L *****

    private static int[][] initL() {
        return new int[][]{
                {9, 1, 9, 9},
                {9, 1, 9, 9},
                {9, 1, 9, 9},
                {9, 1, 1, 9}
        };
    }

    public static Pentamino L(Color color, Point position) {
        return new Pentamino(color, position, initL());
    }

    // ***** N *****

    private static int[][] initN() {
        return new int[][]{
                {9, 9, 1, 9},
                {9, 1, 1, 9},
                {9, 1, 9, 9},
                {9, 1, 9, 9}
        };
    }

    public static Pentamino N(Color color, Point position) {
        return new Pentamino(color, position, initN());
    }

    // ***** P *****

    private static int[][] initP() {
        return new int[][]{
                {9, 9, 1},
                {9, 1, 1},
                {9, 1, 1}
        };
    }

    public static Pentamino P(Color color, Point position) {
        return new Pentamino(color, position, initP());
    }

    // ***** T *****

    private static int[][] initT() {
        return new int[][]{
                {1, 1, 1},
                {9, 1, 9},
                {9, 1, 9}
        };
    }

    public static Pentamino T(Color color, Point position) {
        return new Pentamino(color, position, initT());
    }

    // ***** U *****

    private static int[][] initU() {
        return new int[][]{
                {1, 9, 1},
                {1, 1, 1},
                {9, 9, 9}
        };
    }

    public static Pentamino U(Color color, Point position) {
        return new Pentamino(color, position, initU());
    }

    // ***** V *****

    private static int[][] initV() {
        return new int[][]{
                {1, 9, 9},
                {1, 9, 9},
                {1, 1, 1}
        };
    }

    public static Pentamino V(Color color, Point position) {
        return new Pentamino(color, position, initV());
    }

    // ***** W *****

    private static int[][] initW() {
        return new int[][]{
                {1, 9, 9},
                {1, 1, 9},
                {9, 1, 1}
        };
    }

    public static Pentamino W(Color color, Point position) {
        return new Pentamino(color, position, initW());
    }

    // ***** X *****

    private static int[][] initX() {
        return new int[][]{
                {9, 1, 9},
                {1, 1, 1},
                {9, 1, 9}
        };
    }

    public static Pentamino X(Color color, Point position) {
        return new Pentamino(color, position, initX());
    }

    // ***** Y *****

    private static int[][] initY() {
        return new int[][]{
                {9, 9, 1, 9},
                {9, 1, 1, 9},
                {9, 9, 1, 9},
                {9, 9, 1, 9}
        };
    }

    public static Pentamino Y(Color color, Point position) {
        return new Pentamino(color, position, initY());
    }

    // ***** Z *****

    private static int[][] initZ() {
        return new int[][]{
                {1, 1, 9},
                {9, 1, 9},
                {9, 1, 1}
        };
    }

    public static Pentamino Z(Color color, Point position) {
        return new Pentamino(color, position, initZ());
    }

}