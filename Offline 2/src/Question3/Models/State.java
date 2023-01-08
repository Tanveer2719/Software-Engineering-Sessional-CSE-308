package Question3.Models;


import Question3.Context;
import Question3.HelperClasses.Product;

public abstract class State {
    private static int currentMoney = 0;
    private int productCount = Product.productCount;
    public static Context context;

    public abstract void insertMoney(int amount);
    public abstract void checkMoney();  // check if money is equal or greater or less
    // deliver the product and decrease the product count and based on it move to new state
    public abstract void dispense();
    public abstract void execute();


    public static void setContext(Context con){
        context = con;
    }

    public void setProductCount(int count){
        productCount = count;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int money){
        currentMoney = money;
    }
}
/**
 * The product count and the current money is kept static because it will remain same for all the instance of the Question3.StaticMethods.States.State class
 * Again we can decrease the product count and set the current money to zero if any dispense occurs
 *
 * Since the abstract class is extended by all the states we created an instance for the context class, It will help us to change
 * the states
 *
 * Insert money, checkMoney, dispense and execute are the four methods that will be implemented by all of the states that extends the
 * State class
 *
 */
