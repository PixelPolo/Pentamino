package shapes;

import geometry.Angle;
import geometry.Point;

import java.awt.*;

public abstract class Shape implements Transformable, Displayable {

    // ***** FIELDS *****

    private Color color;
    private Point position;

    // ***** CONSTRUCTOR *****

    protected Shape(Color color) {
        this.color = color;
    }

    // ***** GETTERS AND SETTERS *****

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public abstract Point getCenter();

    public abstract void setCenter(Point center);

    // ***** METHODS *****

    public void rotate(Angle angle) {
        rotate(getCenter(), angle);
    }

    public void scale(Double factor) {
        scale(getCenter(), factor);
    }

    public abstract boolean contains(Point point);

}