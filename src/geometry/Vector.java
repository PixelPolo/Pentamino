package geometry;

public class Vector {

    // ***** FIELDS *****

    private final double dx;
    private final double dy;

    // ***** CONSTRUCTORS *****

    public Vector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Vector(Point point) {
        dx = point.getX();
        dy = point.getY();
    }

    public Vector(Point pointFrom, Point pointTo) {
        dx = pointTo.getX() - pointFrom.getX();
        dy = pointTo.getY() - pointFrom.getY();
    }

    // ***** GETTERS AND SETTERS *****

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    // ***** METHODS *****

    public Vector plus(Vector vector) {
        return new Vector(dx + vector.getDx(), dy + vector.getDy());
    }

    public Vector times(double value) {
        return new Vector(dx * value, dy * value);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "dx=" + dx +
                ", dy=" + dy +
                '}';
    }

}