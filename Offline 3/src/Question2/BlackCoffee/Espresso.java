package Question2.BlackCoffee;

public class Espresso extends BlackCoffeeDecorator {

    public void prepareCoffee(){
        coffee.prepareCoffee();
        System.out.println("\t- Dairy cream(40 tk)");
        coffee.setPrice(coffee.getPrice() + 40); // dairy cream 40 tk
    }

    public int getPrice(){
        return coffee.getPrice();
    }
}
