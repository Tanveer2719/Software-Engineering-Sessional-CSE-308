package Question2.MilkCoffee;

public class Cappuccino extends MilkCoffeeDecorator{

    @Override
    public void prepareCoffee() {
        coffee.prepareCoffee();
        System.out.println("\t- Cinnamon powder(50 tk)");
        coffee.setPrice(coffee.getPrice() + 50); // cinnamon powder = 50tk;
    }

    public int getPrice(){
        return coffee.getPrice();
    }
}
