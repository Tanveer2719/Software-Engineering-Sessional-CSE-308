package Question3.Models;

import Question3.StaticMethods.States;

import java.util.Scanner;

public class HasProduct extends State {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void insertMoney(int amount) {
        setCurrentMoney(amount);
        System.out.println("Your money "+ amount + " is accepted...");
        context.setCurrentState(States.hasMoney);
        context.getCurrentState().checkMoney();
    }

    @Override
    public void checkMoney() {
        System.out.println("There is no money inserted !!");
    }

    @Override
    public void dispense() {
        System.out.println("No money inserted !!");
    }

    @Override
    public void execute() {
        System.out.println("Please enter some amount of money to buy a product....If want to exit then enter 0 : ");
        int x = scanner.nextInt();
        if(x == 0){
            System.out.println("Thank you for your interest in our service. ");
            System.exit(0);
        }else{
            insertMoney(x);
        }
    }

}

/**
 * Has product is the initial state. We implement the insertMoney method and the execute method here
 *
 * If money inserted then we set the currentState to Question3.StaticMethods.States.HasMoney in the context class and set the currentMoney variable in
 * And we also call the checkMoney method of the hasMoney state to check if the money is greater or equal or less
 *
 */
