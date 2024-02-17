package shapes;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

import java.awt.*;

// TODO : Maybe this Class is useless ?!

public class Square extends Shape implements Displayable {

    // ***** FIELDS *****

    private double width;

    // ***** CONSTRUCTOR *****

    public Square(Color color, Point position, double width) {
        super(color, position);
        this.width = width;
    }

    // ***** GETTERS AND SETTERS *****

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public Point getCenter() {
        return new Point(
                getPosition().getX() + width / 2,
                getPosition().getY() + width / 2
        );
    }

    @Override
    public void setCenter(Point center) {
        setPosition(
                new Point(
                        center.getX() + width / 2,
                        center.getY() + width / 2)
        );
    }

    // ***** METHODS *****

    @Override
    public boolean contains(Point point) {
        boolean xInRange = point.getX() > getPosition().getX() && point.getX() < getPosition().getX() + width;
        boolean yInRange = point.getY() > getPosition().getY() && point.getY() < getPosition().getY() + width;
        return xInRange && yInRange;
    }

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

    @Override
    public void display(Graphics2D graphics2D) {
        graphics2D.setColor(this.getColor());
        graphics2D.fillRect(
                (int) getPosition().getX(),
                (int) getPosition().getY(),
                (int) this.width, (int) this.width
        );
    }

}