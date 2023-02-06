package Question2.MilkCoffee;

public class Mocha extends MilkCoffeeDecorator{

    public void prepareCoffee(){
        coffee.prepareCoffee();
        System.out.println("\t- Chocolate sauce(60 tk)");
        coffee.setPrice(coffee.getPrice() + 60); // Chocolate sauce = 60tk;
    }
    public int getPrice(){
        return coffee.getPrice();
    }
}
