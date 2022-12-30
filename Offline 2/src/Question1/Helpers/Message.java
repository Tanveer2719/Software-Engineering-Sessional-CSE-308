package Question1.Helpers;

import Question1.Controller.Controller;

import java.util.Scanner;

import static Question1.Helpers.Var.*;

public class Message{
    Scanner scanner = new Scanner(System.in);

    Controller control;

    public void setController(Controller controller){
        this.control = controller;
    }

    public void PartiallyDownFromOperational(String code, String name){

        switch (code){
            case "prem":
            {
                printPremHeading(name);
                System.out.println("Choose your type of service: ");
                System.out.println("1. Partially from ABC and DEF\n2. Full service from DEF");
                int x = take_input();
                if(x == 1){
                    System.out.println("Service is supplying from both the servers partially");
                }
                else{
                    System.out.println("Service is supplying from server : DEF only");
                }
                // notify the controller class;
                control.activator();
                break;
            }
            case "free":
            {
                printFreeHeading(name);
                System.out.println("Choose your type of service: ");
                System.out.println("1. Partial service\n2. Full service after paying 20$ per hour");
                int x = take_input();
                if(x == 2){
                    System.out.println("You have to pay 20$ per hour and enjoy our full functionality");
                    payment = true;
                }
                else{
                    System.out.println("Okay...You will have partial functionality now !!!");
                }

                // notify the controller class
                control.activator();
                break;
            }

        }

    }

    public void FullyDownFromOperational(String code, String name){

        switch (code){
            case "prem":
            {
                printPremHeading(name);
                System.out.println("Now you are getting service from DEF server");
                control.activator();
                break;
            }
            case "free": {
                printFreeHeading(name);
                System.out.println("Do you want to pay 20$ per hour and get full service ?");
                System.out.println("1. Yes\n2. No");
                int x = take_input();
                if(x == 1){
                    System.out.println("Congratulations...You will get full functionality at the cost of 20$ per hour");
                    payment  = true;
                }
                else{
                    System.out.println("Sorry...Your service will be currently unavailable...");
                }

                control.activator();
                break;
            }

        }
    }

    public void operationalFromPartiallyDown(String code, String name){
        switch (code){
            case "prem":
            {
                printPremHeading(name);
                System.out.println("Now you are getting service from ABC server");
                control.activator();
                break;
            }
            case "free": {
                printFreeHeading(name);
                System.out.println("Now you can get free service from our service");
                if(payment){
                    System.out.println("You have to pay 100$ for your previous usage");
                    payment = false;
                }
                control.activator();
                break;
            }

        }
    }

    public void operationalFromFullyDown(String code, String name){
        operationalFromPartiallyDown(code, name);
    }

    public void fullyDownFromPartiallyDown(String code, String name){
        switch (code){
            case "prem":
            {
                printPremHeading(name);
                System.out.println("Now you are getting service from DEF server alone");
                control.activator();
                break;
            }
            case "free": {
                printFreeHeading(name);
                if(payment){
                    System.out.println("You will get service from DEF server at cost 20$ per hour");
                }else{
                    System.out.println("Sorry...Your service will be unavailable until the server ABC is activated");
                }
                control.activator();
                break;
            }
        }
    }

    public void partiallyDownFromFullyDown(String code, String name){
        switch (code){
            case "prem":
            {
                printPremHeading(name);
                System.out.println("Now you are getting service from DEF server alone");
                control.activator();
                break;
            }
            case "free": {
                printFreeHeading(name);
                if(payment){
                    System.out.println("You will get full service at cost 20$ per hour");
                }else{
                    System.out.println("Sorry...Your service will be partially available.");
                }
                control.activator();
                break;
            }
        }

    }

    private void printPremHeading(String name){
        System.out.println("\nPREMIUM SERVICE");
        System.out.println("USERNAME: " + name);
    }

    private void printFreeHeading(String name){
        System.out.println("\nFREE SERVICE");
        System.out.println("USERNAME: " + name);
    }

    private int take_input(){
        int x = scanner.nextInt();
        while(x < 1 && x > 2) {
            System.out.println("Press 1 for YES and 2 for NO");
            x = scanner.nextInt();
        }
        return x;
    }

}

/**
 * This is a helper class that helps to print various messages of the users
 * The first 6 methods help to print various state change message
 * "printPremHeading()" and "printFreeHeading()" help to print in the above 6 methods
 *
 * "take_input()" is a method that helps to take an input between 1 and 2 for selection purpose
 *
 *
 */
