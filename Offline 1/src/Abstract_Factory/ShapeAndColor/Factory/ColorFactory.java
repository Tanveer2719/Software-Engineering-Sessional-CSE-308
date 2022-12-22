package Abstract_Factory.ShapeAndColor.Factory;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Blue;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Color;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Green;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Yellow;
import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String type){
        if (type.equalsIgnoreCase("yellow")){
            return new Yellow();
        }
        else if(type.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        else if(type.equalsIgnoreCase("Green")){
            return new Green();
        }

        return null;
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }




}
