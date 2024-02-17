package shapes;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

import java.awt.*;
import java.util.Arrays;

public abstract class MatrixShape extends Shape {

    // ***** FIELDS *****

    private int[][] matrix;

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

    // TODO
    @Override
    public Point getCenter() {
        return null;
    }

    // TODO
    @Override
    public void setCenter(Point center) {

    }

    // ***** METHODS *****

    // TODO
    @Override
    public boolean contains(Point point) {
        return false;
    }

    // TODO
    @Override
    public void translate(Vector vector) {

    }

    // TODO
    @Override
    public void rotate(Point center, Angle angle) {

    }

    // TODO
    @Override
    public void scale(Point refPoint, Double factor) {

    }

    // TODO
    @Override
    public void display(Graphics2D graphics2D) {

    }

}