package Builder_Pattern.Models;

import Builder_Pattern.Product;

public interface Builder {
    void startUpOperations();
    void buildBody();
    void addHeadLights();
    void insertWheels();
    void endOperations();


    Product getProduct();


}
