package Builder_Pattern.Models;

import Builder_Pattern.Product;

public class Car implements Builder{
    private String brandName;
    private Product product;

    public Car(String brand){
        product = new Product();
        this.brandName = brand;
    }

    @Override
    public void startUpOperations() {
        product.addProduct(String.format("Car model is: " +brandName));
    }

    @Override
    public void buildBody() {
        product.addProduct(String.format("Car body is built"));
    }

    @Override
    public void addHeadLights() {
        product.addProduct(String.format("Two headlights are added in the front."));
    }

    @Override
    public void insertWheels() {
        product.addProduct(String.format("4 wheels are added."));
    }

    @Override
    public void endOperations() {
        product.addProduct(String.format("Car building completed"));
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
