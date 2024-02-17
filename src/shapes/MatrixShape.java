package shapes;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

import java.awt.*;
import java.util.Arrays;

public abstract class MatrixShape extends Shape {

    // ***** FIELDS *****

    private int[][] matrix;
    private int TILE_WIDTH = 10;

    // ***** CONSTRUCTOR *****

    public MatrixShape(Color color, Point position, int[][] matrix) {
        super(color, position);
        this.matrix = matrix;
    }

    // ***** GETTERS AND SETTERS *****

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = Arrays.copyOf(matrix, matrix.length);
    }

    @Override
    public Point getCenter() {
        return new Point(
                (int) (getPosition().getX() + matrix.length / 2),
                (int) (getPosition().getY() + matrix[0].length / 2)
        );
    }

    @Override
    public void setCenter(Point center) {
        setPosition(new Point(
                    (int) (center.getX() + matrix.length / 2),
                    (int) (center.getY() + matrix[0].length / 2)
                )
        );
    }

    // ***** METHODS *****

    @Override
    public boolean contains(Point point) {
        int colIndex = (int) point.getX() / TILE_WIDTH;
        int rowIndex = (int) point.getY() / TILE_WIDTH;
        if (colIndex >= 0 && colIndex < matrix.length &&
                rowIndex >= 0 && rowIndex < matrix[0].length) {
            return matrix[rowIndex][colIndex] != 0;
        }
        return false;
    }

    // TODO ... THINK ABOUT ***** SHAPE ROTATIONS *****

    @Override
    public void translate(Vector vector) {
        getPosition().translate(vector);
    }

    @Override
    public void rotate(Point center, Angle angle) {
        getPosition().rotate(angle, center);
    }

    @Override
    public void scale(Point refPoint, Double factor) {
        // TODO NOT SURE ABOUT THIS ONE
        TILE_WIDTH *= factor;
        getPosition().scale(factor, refPoint);
    }

    // ***** MATRIX 90 DEGREES ROTATIONS *****
    // https://www.javatpoint.com/rotate-matrix-by-90-degrees-in-java

    private void checkIfSquareMatrix() {
        int length = matrix.length;
        if (length != matrix[0].length) {
            throw new UnsupportedOperationException(
                    "Not implemented with a non-square matrix"
            );
        }
    }

    private void transposeMatrix() {
        checkIfSquareMatrix();
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public void reverseColOrder() {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }

    public void reverseRowOrder() {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int[] tempRow = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = tempRow;
        }
    }

    public void rotateMatrixRight() {
        transposeMatrix();
        reverseColOrder();
    }

    public void rotateMatrixLeft() {
        transposeMatrix();
        reverseRowOrder();
    }

    // ***** DISPLAY AND TO STRING *****

    @Override
    public void display(Graphics2D graphics2D) {
        int color;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                color = matrix[i][j];
                if (color == 1) graphics2D.setColor(this.getColor());
                else graphics2D.setColor(Color.BLACK);
                graphics2D.fillRect(
                        (int) getPosition().getX() + i * TILE_WIDTH,
                        (int) getPosition().getY() + j * TILE_WIDTH,
                        TILE_WIDTH, TILE_WIDTH
                );
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(this.getClass().getSimpleName());
        sb.append("\n\t").append("Position : ").append(getPosition()).append("\n");
        for (int[] row : matrix) {
            sb.append("\t");
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}