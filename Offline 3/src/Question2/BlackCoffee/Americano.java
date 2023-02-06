package Question2.BlackCoffee;

public class Americano extends BlackCoffeeDecorator {

    public void prepareCoffee() {
        coffee.prepareCoffee();
        System.out.println("\t- Grind Coffee beans(30 tk)");
        coffee.setPrice(coffee.getPrice() + 30);        // cost for adding grind coffee beans
    }
    public int getPrice(){
        return coffee.getPrice();
    }


}
