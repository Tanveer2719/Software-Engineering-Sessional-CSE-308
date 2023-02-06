package Question2.BlackCoffee;

import Question2.Coffee;

public class BlackCoffee extends Coffee {

    @Override
    public void prepareCoffee() {
        System.out.println("\t- Water(0 tk) \n\t- Coffee Beans(30 tk)");
        price += 30; // cost for adding beans
    }

    @Override
    public int getPrice() {
        return price;
    }
}
