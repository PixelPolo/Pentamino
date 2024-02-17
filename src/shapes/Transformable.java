package shapes;

import geometry.Angle;
import geometry.Point;
import geometry.Vector;

public interface Transformable {

    public void translate(Vector vector);
    public void rotate(Point center, Angle angle);
    public void scale(Point refPoint, Double factor);

}
