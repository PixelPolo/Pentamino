package shapes.pentamino;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;
import shapes.Shape;

import java.awt.*;
import java.util.Arrays;

public abstract class MatrixShape extends Shape {

    // ***** FIELDS *****

    private int[][] matrix;
    public static int TILE_WIDTH = 50;

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
        int deltaX = (int) (point.getX() - getPosition().getX());
        int deltaY = (int) (point.getY() - getPosition().getY());
        if (deltaX >= 0 && deltaY >= 0) {
            int colIndex = deltaX / TILE_WIDTH;
            int rowIndex = deltaY / TILE_WIDTH;
            if (rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length) {
                return matrix[rowIndex][colIndex] != 9;
            }
        }
        return false;
    }

    // TODO THINK ABOUT SHAPE ROTATIONS

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
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                color = matrix[row][col];
                if (color == 1) {
                    graphics2D.setColor(this.getColor());
                    drawRect(row, col, graphics2D);
                } else if (color == 0) {
                    graphics2D.setColor(Color.BLACK);
                    drawRect(row, col, graphics2D);
                }
            }
        }
    }

    private void drawRect(int row, int col, Graphics2D graphics2D) {
        graphics2D.fillRect(
                (int) getPosition().getX() + col * TILE_WIDTH,
                (int) getPosition().getY() + row * TILE_WIDTH,
                TILE_WIDTH, TILE_WIDTH
        );
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