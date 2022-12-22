package Abstract_Factory.ShapeAndColor.Factory;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Color;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String type);
    public abstract Shape getShape(String type);
}
