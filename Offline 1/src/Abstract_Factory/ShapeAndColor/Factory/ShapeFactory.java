package Abstract_Factory.ShapeAndColor.Factory;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Color;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Circle;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Rectangle;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Shape;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(String type) {
        return null;
    }

    @Override
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")){
            return new Circle();
        }
        else if(type.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        else if(type.equalsIgnoreCase("Square")){
            return new Rectangle();
        }

        return null;
    }

}
