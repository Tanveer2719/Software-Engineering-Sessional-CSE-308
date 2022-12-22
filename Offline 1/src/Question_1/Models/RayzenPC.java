package Question_1.Models;

import Question_1.Enums.Processors;
import Question_1.Product;

import java.util.List;

public class RayzenPC implements PCBuilder{
    Product product;
    Processors p;
    int totalPrice;

    public RayzenPC(){
        product = new Product();
        totalPrice = 70000;
        initialAddition();
        addProcessor();

    }

    void initialAddition(){
        product.add("This is a Gaming PC");
        product.add(String.format("The PC initially had CPU, Motherboard and 1 TB HDD having total price %s BDT", totalPrice));
    }

    void addProcessor(){
        product.add(String.format("%s processor added having price %s BDT",p.Rayzen.getName(), p.Rayzen.getPrice()));
        totalPrice += p.Rayzen.getPrice();
    }

    // list[0] = RAM size  list[1] = RAM freq  list[3] = RAM price
    @Override
    public void addRAM(List<String> list) {
        product.add(String.format("%s GB DDR4 RAM of %s Hz having cost %s BDT added", list.get(0), list.get(1), list.get(2)));
        totalPrice += Integer.parseInt(list.get(2));
    }

    // list[0] = Graphics Card size     list[1] = price
    @Override
    public void addGraphicsCard(List<String> list) {
        product.add(String.format("%s GB Graphics Card having cost %s BDT added", list.get(0), list.get(1)));
        totalPrice += Integer.parseInt(list.get(1));
    }

    private void finalBuildUp() {
        product.add(String.format("Total price of building up the PC is %s BDT", totalPrice));
    }

    @Override
    public Product getPC() {
        finalBuildUp();
        return product;
    }


}
