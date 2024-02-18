package geometry;

import java.util.Objects;

public class Point {

    // ***** FIELDS *****

    private double x;
    private double y;

    // ***** CONSTRUCTOR *****

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        x = point.getX();
        y = point.getY();
    }

    public Point copy() {
        return new Point(x, y);
    }

    // ***** GETTERS AND SETTERS *****

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // ***** METHODS *****

    public double distance(Point other) {
        double dx = Math.abs(other.x - x);
        double dy = Math.abs(other.y - y);
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public void translate(Vector delta) {
        x += delta.getDx();
        y += delta.getDy();
    }

    public void rotate(Angle angle, Point center) {
        double dx = x - center.x;
        double dy = y - center.y;
        x = center.x + dx * angle.cos() - dy * angle.sin();
        y = center.y + dx * angle.sin() + dy * angle.cos();
    }

    public void scale(double factor, Point center) {
        x = center.x + factor * (x - center.x);
        y = center.y + factor * (y - center.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Point point = (Point) other;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "( " + x + " : " + y + " )";
    }

}