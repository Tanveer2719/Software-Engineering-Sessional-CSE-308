package Online;

public class Circle extends Shape {
    int rad;
    public Circle(){}
    public Circle(int x){
        rad = x;
    }


    @Override
    public float surface_area() {
        return (float) (3.1416 * rad * rad);
    }

    @Override
    public float perimeter() {
        return (float) (2 * 3.1416 * rad);
    }
}
