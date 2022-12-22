package Question_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> orderList = new ArrayList<>();
        Director director = new Director();

        int count = 0;

        do{
            System.out.println("\nPress 'O' to place an order\nPress Q to exit");
            System.out.println("Enter your response:");
            char ins = scanner.next().charAt(0);

            // if he Press Q then quit the prompt
            if(ins == 'Q' && count == 0){
                System.out.println("Please order Something....\n");
                continue;
            }
            else if (ins  == 'Q' && count > 0){
                System.out.println("Thank you for being with us\n");
                break;
            }

            // Starts an order
            else if(ins =='O'){

                System.out.println("********** Select which pc to build **********");
                printPcCategory();         // what category of PC the user want to build ?
                int choice = scanner.nextInt();     // take the choice of the user

                while(choice > 4 || choice < 1){
                    System.out.println("Wrong input...Try again !!");
                    choice = scanner.nextInt();
                }

                // start building the pc of required choice
                director.construct(choice);

                // ask if wants to add extra ram and graphics card
                while(true) {
                    System.out.println("********** Enter A for add more, E for finish placing the order **********");
                    char endCommand = scanner.next().charAt(0);

                    if (endCommand == 'E') {
                        break;
                    }
                    else if (endCommand == 'A') {
                        printChoiceOfRamGraphics();
                        int rgChoice = scanner.nextInt();
                        while (rgChoice > 4 || rgChoice < 1) {
                            System.out.println("Wrong input...Try again !!");
                            rgChoice = scanner.nextInt();
                        }

                        director.addExtra(rgChoice);    // send the choice to the director
                    }
                    else
                    {
                        System.out.println("Wrong input...Try again");
                    }
                }

                System.out.println("Thank you...Your Order is Completed !!!!");
                Product product = director.getProduct();
                orderList.add(product);

                count ++;   // increase the order count

            }
        }while (true);

        System.out.println("You have ordered " + count + " PC(s)\n");
        int c = 1;
        for( Product x: orderList){
            System.out.println("\nOrder no# "+ c);
            x.showParts();
            c++;
        }

    }

    private static void printPcCategory() {
        System.out.println("Enter any of the index of your choice");
        System.out.println("1. Gaming Pc");
        System.out.println("2. Intel Corei5");
        System.out.println("3. Intel Corei7");
        System.out.println("4. Inter Corei9");
    }
    private static void printChoiceOfRamGraphics(){
        System.out.println("Enter any of the index of your choice");
        System.out.println("1. 8 GB 2666 MHz DDR4 RAM - Price 2620 BDT ");
        System.out.println("2. 8 GB 3200 MHz DDR4 RAM - Price 2950  BDT ");
        System.out.println("3. 2GB graphics card - Price 6500 BDT");
        System.out.println("4. 4GB graphics card - Price 7600  BDT");
    }
}
