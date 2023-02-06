package Question2.MilkCoffee;

import Question2.Coffee;

public class MilkCoffee extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("\t- Milk(50 tk) \n\t- Coffee Beans(30 tk)");
        price += 80; // coffee beans and milk
    }

    @Override
    public int getPrice() {
        return price;
    }
}
