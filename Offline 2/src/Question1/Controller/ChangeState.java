package Question1.Controller;

import java.util.Scanner;

import static Question1.Helpers.Var.*;

public class ChangeState {
    Scanner scanner = new Scanner(System.in);

    int changeCurrentState(){
        System.out.println("Press to change the state: ");

        if(operational){
            System.out.println("1. Partially down \n2. Fully down");
            int x = take_input();

            if(x == 1){
                code = "op";
                return 2;
            }
            else{
                code = "of";
                return 3;
            }

        }
        else if (partially_down){
            System.out.println("1. Operational \n2. Fully down");
            int x = take_input();

            if(x == 1){
                code = "po";
                return 1;
            }
            else{
                code = "pf";
                return 3;
            }
        }
        else{
            System.out.println("1. Operational \n2. Partially down");
            int x = take_input();

            if(x == 1){
                code = "fo";
                return 1;
            }
            else{
                code = "fp";
                return 2;
            }
        }
    }

    private int take_input(){
        int x = scanner.nextInt();
        while(x > 2 || x < 1){
            System.out.println("Press correctly");
            x = scanner.nextInt();
        }
        return x;
    }

}

/**
 * In ChangeState() -> we pick the next possible states from current state and change the Static variables according to the user
 *                    input.
 *                    We also assign a String code name for tracking the previous and the current state.Helps to call methods
 *
 *                    we pick a random ordering for current state....if current state is operational then return 1
 *                                                                return 2 and 3 for partially and fully down states respectively
 *
 *
 */
