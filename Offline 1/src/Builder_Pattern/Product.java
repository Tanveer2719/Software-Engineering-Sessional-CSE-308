package Builder_Pattern;

import java.util.LinkedList;

public class Product {
    private LinkedList<String> product_parts;

    public Product(){
        product_parts = new LinkedList<String>();
    }

    public void addProduct(String part){
        product_parts.add(part);
    }
    public void show_product(){
        System.out.println("The parts added to the product are: ");
        int i = 1;
        for(String a: product_parts){
            System.out.println(a);
        }
    }
}
