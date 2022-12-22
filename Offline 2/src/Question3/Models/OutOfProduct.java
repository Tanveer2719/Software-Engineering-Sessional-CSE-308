package Question3.Models;



import java.util.Scanner;

public class OutOfProduct extends State {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void insertMoney(int amount) {
        System.out.println("Sorry we have no product available");
    }

    @Override
    public void checkMoney() {
        System.out.println("Sorry we have no product available");
    }

    @Override
    public void dispense() {
        System.out.println("Sorry we have no product available");
    }

    @Override
    public void execute() {
        System.out.println("Sorry we are out of product...we can not process any request");
        while(true){
            System.out.println("Press 0 to exit: ");
            int x = scanner.nextInt();
            if(x == 0)
                System.exit(0);
        }


    }

}
