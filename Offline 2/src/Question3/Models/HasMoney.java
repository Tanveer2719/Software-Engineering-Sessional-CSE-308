package Question3.Models;

import Question3.StaticMethods.Product;
import Question3.StaticMethods.States;

public class HasMoney extends State {

    @Override
    public void insertMoney(int amount) {
        System.out.println("You have already inserted money...Please wait");
    }

    @Override
    public void checkMoney() {
        if(Product.price > getCurrentMoney()){
            // System.out.println("The money you have inserted is less then the product price...Please insert more money");
            context.setCurrentState(States.lessMoney);
            context.getCurrentState().execute();
        }
        else if (Product.price == getCurrentMoney()){
            System.out.println("The money you have inserted is equal to the product price...Please wait for confirmation");
            context.setCurrentState(States.sold);
            context.getCurrentState().dispense();
        }
        else{
            System.out.println("The money you have inserted is more then the product price...Please wait for the return");
            context.setCurrentState(States.moreMoney);
            context.getCurrentState().execute();
        }

    }

    @Override
    public void dispense() {
        System.out.println("You can not dispense product now");
    }

    @Override
    public void execute() {

    }

}

/**
 * If the money inserted by the purchaser is equal to the product price then we move to state Sold and execute the dispense method
 * If the money is less then we go to lessMoney state and ask for more money
 * else we go to the Greater money state and call the execute method of the greater money state.
 */
