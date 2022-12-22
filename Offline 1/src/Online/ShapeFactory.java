package Online;

public class ShapeFactory {
    private Shape shape;

    void setShape(String x){
        if(x.equalsIgnoreCase("circle")){
            shape = new Circle();
        }else if(x.equalsIgnoreCase("rectangle")){
            shape = new Rectangle();
        }else if(x.equalsIgnoreCase("Square")){
            shape = new Square();
        }
    }

    Shape getShape(){return shape;}
}
