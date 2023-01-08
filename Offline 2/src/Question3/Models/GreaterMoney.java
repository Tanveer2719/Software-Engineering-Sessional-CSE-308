package Question3.Models;

import Question3.HelperClasses.Product;
import Question3.HelperClasses.States;

public class GreaterMoney extends State {

    @Override
    public void insertMoney(int amount) {
        System.out.println("you have already inserted more money");
    }

    @Override
    public void checkMoney() {
        System.out.println("Your money is Processing");
    }

    @Override
    public void dispense() {
        System.out.println("The machine need to return you some money");
    }

    @Override
    public void execute() {
        int x = getCurrentMoney() - Product.price;
        System.out.println("You have "+x+ " tk returned.");
        setCurrentMoney(x);
        context.setCurrentState(States.sold);
        context.getCurrentState().dispense();

    }
}

/**
 * The execute method returns back The extra money first and then moves to the sold state of dispense the product
 */
