package Question3.Models;

import Question3.HelperClasses.States;

public class Sold extends State {
    @Override
    public void insertMoney(int amount) {
        System.out.println("You cannot insert money now !!!");
    }

    @Override
    public void checkMoney(){
        System.out.println("You have already asked for a product.Wait for the completion of the purchase");
    }

    @Override
    public void dispense() {
        setProductCount(getProductCount() - 1);
        setCurrentMoney(0);

        System.out.println("Your product has been delivered.\n");
        // System.out.println("Current money is reduced to 0.");

        if(getProductCount() == 0){
            context.setCurrentState(States.outOfProduct);
            // System.out.println("Moved to state \"Out of Product\"");
            context.getCurrentState().execute();
        }else{
            context.setCurrentState(States.hasProduct);
            // System.out.println("Moved to state \"HasProduct\"");
            context.getCurrentState().execute();

        }
    }

    @Override
    public void execute() {
        System.out.println("Nothing to execute");
    }
}

/**
 * from dispense we can move to two states based on the product count
 * If the product count is zero then we go to the outOfProduct state
 * else we go the hasProduct state after decreasing the product count and then again ask for money to buy again
 */
