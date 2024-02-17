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

    protected MatrixShape(Color color, int[][] matrix) {
        super(color);
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

    @Override
    public void translate(Vector vector) {
        getPosition().translate(vector);
    }

    // TODO ROTATE THE MATRIX
    @Override
    public void rotate(Point center, Angle angle) {
        getPosition().rotate(angle, center);
    }

    // TODO NOT SURE ABOUT THIS ONE
    @Override
    public void scale(Point refPoint, Double factor) {
        TILE_WIDTH *= factor;
        getPosition().scale(factor, refPoint);
    }

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
        sb.append("\n").append(this.getClass().getSimpleName()).append("\n");
        for (int[] row : matrix) {
            sb.append("\t");
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

}