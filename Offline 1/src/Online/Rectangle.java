package Online;

public class Rectangle extends Shape {
    int width, length;
    public Rectangle(){

    }
    public Rectangle(int x,int y){
        length = x;
        width = x;
    }

    @Override
    float surface_area() {
        return width*length;
    }

    @Override
    float perimeter() {
        return 2*(length + width);
    }
}
