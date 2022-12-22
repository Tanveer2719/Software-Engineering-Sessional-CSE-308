package Abstract_Factory.ShapeAndColor.Factory;

public class FactoryProducer {

    public AbstractFactory getFactory(String type){
        if(type.equalsIgnoreCase("Shape")){
            return new ShapeFactory();
        }
        else if(type.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }

}
