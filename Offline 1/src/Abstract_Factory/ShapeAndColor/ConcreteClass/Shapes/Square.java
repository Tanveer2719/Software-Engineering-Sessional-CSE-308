package Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes;

import Abstract_Factory.ShapeAndColor.ConcreteClass.Shapes.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square Drawn");
    }
}
