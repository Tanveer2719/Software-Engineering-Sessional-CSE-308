package Builder_Pattern.Models;

import Builder_Pattern.Product;

public class Motorcycle implements Builder{
    private String brandName;
    private Product product;

    public Motorcycle(String brand){
        product = new Product();
        this.brandName = brand;
    }

    @Override
    public void startUpOperations() {
        product.addProduct(String.format("MotorCycle model is: " +brandName));
    }

    @Override
    public void buildBody() {
        product.addProduct(String.format("MotorCycle body is built"));
    }

    @Override
    public void addHeadLights() {
        product.addProduct(String.format("One headlight is added in the front."));
    }

    @Override
    public void insertWheels() {
        product.addProduct(String.format("2 wheels are added."));
    }

    @Override
    public void endOperations() {
        product.addProduct(String.format("MotorCycle building completed"));
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
