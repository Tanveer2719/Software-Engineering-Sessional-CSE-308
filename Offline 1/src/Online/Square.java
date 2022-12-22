package Online;

public class Square extends Shape{
    int width, length;

    public Square(){

    }

    public Square(int x){
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

