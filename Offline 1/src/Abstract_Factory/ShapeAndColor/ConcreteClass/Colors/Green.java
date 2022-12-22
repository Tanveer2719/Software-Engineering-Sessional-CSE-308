package Abstract_Factory.ShapeAndColor.ConcreteClass.Colors;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Green colored");
    }
}
