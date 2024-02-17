package shapes;

import geometry.Angle;
import geometry.Point;

import java.awt.*;

public abstract class Shape implements Transformable, Displayable {

    // ***** FIELDS *****

    private Color color;
    private Point position;

    // ***** CONSTRUCTOR *****

    public Shape(Color color, Point position) {
        this.color = color;
        this.position = position;
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

    // ***** ABSTRACT GETTERS AND SETTERS *****

    public abstract Point getCenter();

    public abstract void setCenter(Point center);

    // ***** METHODS *****

    public void rotate(Angle angle) {
        rotate(getCenter(), angle);
    }

    public void scale(Double factor) {
        scale(getCenter(), factor);
    }

    // ***** ABSTRACT METHODS *****

    public abstract boolean contains(Point point);

}