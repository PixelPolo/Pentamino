package shapes.interfaces;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

public interface Transformable {

    void translate(Vector vector);

    void rotate(Point center, Angle angle);

    void scale(Point refPoint, Double factor);

}
