package geometry;

public class Angle {

    // ***** FIELDS *****

    private final double degrees;

    // ***** CONSTRUCTOR *****

    public Angle(double dx, double dy) {
        double radian = Math.atan2(dy, dx);
        degrees = Math.toDegrees(radian);
    }

    // ***** STATIC FACTORY METHODS *****

    public static Angle inDegrees(double value) {
        double dx = Math.cos(Math.toRadians(value));
        double dy = Math.sin(Math.toRadians(value));
        return new Angle(dx, dy);
    }

    public static Angle inRadians(double value) {
        double dx = Math.cos(value);
        double dy = Math.sin(value);
        return new Angle(dx, dy);
    }

    // ***** GETTERS AND SETTERS *****

    public double getDegrees() {
        return degrees;
    }

    public double getRadians() {
        return Math.toRadians(degrees);
    }

    // ***** METHODS *****

    public double sin() {
        if (degrees == 180 || degrees == 360) return 0;
        else return Math.sin(Math.toRadians(degrees));
    }

    public double cos() {
        if (degrees == 90 || degrees == 270) return 0;
        else return Math.cos(Math.toRadians(degrees));
    }

    public Angle plus(Angle other) {
        return inDegrees(degrees + other.getDegrees());
    }

    public Angle minus(Angle other) {
        return inDegrees(degrees - other.getDegrees());
    }

    public Angle multiply(double factor) {
        return inDegrees(degrees * factor);
    }

    @Override
    public String toString() {
        return "Angle{" +
                "degrees=" + degrees +
                '}';
    }

}