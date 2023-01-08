package Question3.Models;

import Question3.HelperClasses.Product;
import Question3.HelperClasses.States;

import java.util.Scanner;

public class LessMoney extends State {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void insertMoney(int amount) {
        System.out.println("Wrong Method called");
    }

    @Override
    public void checkMoney() {
        System.out.println("You already have less money..Please insert more");
    }

    @Override
    public void dispense() {
        System.out.println("You have less money..Please insert more");

    }

    @Override
    public void execute() {
        System.out.println("Please insert " + (Product.price - getCurrentMoney()) +" tk more for the completion of the purchase");
        int x = scanner.nextInt();
        setCurrentMoney(getCurrentMoney() + x);
        context.setCurrentState(States.hasMoney);
        context.getCurrentState().checkMoney();

    }

}
/**
 * In the execute method of the state we ask the user for more money and then call the checkMoney method of the hasMoney state again;
 */
