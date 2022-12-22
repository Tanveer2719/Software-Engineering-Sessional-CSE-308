package Question_1.Models;

import Question_1.Enums.Coolers;
import Question_1.Enums.Processors;
import Question_1.Product;

import java.util.List;

public class Intel7PC implements PCBuilder {
    Product product;
    Processors p;
    Coolers c;
    int totalPrice;

    public Intel7PC(){
        product = new Product();
        totalPrice = 70000;
        initialAddition();
        addProcessor();
        addCooler();
    }

    private void finalBuildUp() {
        product.add(String.format("Total price of building up the PC is %s BDT", totalPrice));
    }

    private void initialAddition(){
        product.add("This is Intel Corei7 PC");
        product.add(String.format("This 11th Generation PC initially had CPU, Motherboard and 1 TB HDD having total price %s BDT", totalPrice));
    }

    private void addProcessor(){
        product.add(String.format("%s processor added having price %s BDT",p.Intel7.getName(), p.Intel7.getPrice()));
        totalPrice += p.Intel7.getPrice();
    }

    private void addCooler(){
        product.add(String.format("Liquid Cooler added having price %s BDT", c.liqCooler.getPrice()));
        totalPrice += c.liqCooler.getPrice();
    }

    @Override
    public void addRAM(List<String> list) {
        product.add(String.format("%s GB DDR4 RAM of %s Hz having cost %s BDT added", list.get(0), list.get(1), list.get(2)));
        totalPrice += Integer.parseInt(list.get(2));
    }

    @Override
    public void addGraphicsCard(List<String> list) {
        product.add(String.format("%s GB Graphics Card having cost %s BDT added", list.get(0), list.get(1)));
        totalPrice += Integer.parseInt(list.get(1));
    }

    @Override
    public Product getPC() {
        finalBuildUp();
        return product;
    }
}
