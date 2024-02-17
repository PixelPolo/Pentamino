package shapes;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

import java.awt.*;

// TODO : Maybe this Class is useless ?!

public class Square extends Shape implements Displayable {

    // ***** FIELDS *****

    private Point position;
    private double width;

    // ***** CONSTRUCTOR *****

    public Square(Color color, Point position, double width) {
        super(color);
        this.position = position;
        this.width = width;
    }

    // ***** GETTERS AND SETTERS *****

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public Point getCenter() {
        return new Point(position.getX() + width / 2, position.getY() + width / 2);
    }

    @Override
    public void setCenter(Point center) {
        position = new Point(center.getX() + width / 2, center.getY() + width / 2);
    }

    // ***** METHODS *****

    @Override
    public boolean contains(Point point) {
        boolean xInRange = point.getX() > position.getX() && point.getX() < position.getX() + width;
        boolean yInRange = point.getY() > position.getY() && point.getY() < position.getY() + width;
        return xInRange && yInRange;
    }

    @Override
    public void translate(Vector vector) {
        position.translate(vector);
    }

    @Override
    public void rotate(Point center, Angle angle) {
        position.rotate(angle, center);
    }

    @Override
    public void scale(Point refPoint, Double factor) {
        position.scale(factor, refPoint);
    }

    @Override
    public void display(Graphics2D graphics2D) {
        graphics2D.setColor(this.getColor());
        graphics2D.fillRect(
                (int) position.getX(), (int) position.getY(),
                (int) this.width, (int) this.width
        );
    }

}