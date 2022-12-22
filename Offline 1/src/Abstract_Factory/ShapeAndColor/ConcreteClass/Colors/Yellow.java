package Abstract_Factory.ShapeAndColor.ConcreteClass.Colors;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Colors.Color;

public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Yellow colored");
    }
}
