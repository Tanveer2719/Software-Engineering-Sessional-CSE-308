package Question2;

import Question2.BlackCoffee.Americano;
import Question2.BlackCoffee.Espresso;
import Question2.MilkCoffee.Cappuccino;
import Question2.MilkCoffee.Mocha;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffeeName = new ArrayList<>(Arrays.asList("Americano", "Espresso", "Cappuccino", "Mocha"));
        HashMap<String, Integer> order = new HashMap<>(); // <coffee name, how many>
        boolean hasOrdered = false;

        while(true){

            System.out.println("Press '0' for quit, anyOther number for Order");
            int character = scanner.nextInt();
            if(character == 0){
                System.out.println("Thank you for having interest in us");
                break;
            }

            System.out.println("Which type of Coffee do you want to order : ");
            for(int i = 0;i<coffeeName.size(); i++){
                System.out.println((i+1) + ". " + coffeeName.get(i));
            }

            int nameIndex = scanner.nextInt();
            while(nameIndex >4 || nameIndex<1){
                System.out.println("Please enter a valid number");
                nameIndex = scanner.nextInt();
            }

            if(order.containsKey(coffeeName.get(nameIndex-1))){
                System.out.println("You have already ordered this type of Coffee");
                continue;
            }

            System.out.println("Enter quantity: ");
            int quantity = scanner.nextInt();
            while(quantity<1){
                System.out.println("Please order at least one");
                quantity = scanner.nextInt();
            }

            order.put(coffeeName.get(nameIndex-1), quantity );
            hasOrdered = true;
        }

        int totalPriceOfOrder = 0;

        for(String s: order.keySet()){
            if(s.equals("Americano")){
                Coffee americano = new Americano();
                System.out.println("Ingredients for Americano: ");
                americano.prepareCoffee();
                System.out.println("Price for Americano: "+ americano.getPrice());
                totalPriceOfOrder += order.get(s) * americano.getPrice();
            }
            else if(s.equals("Espresso")){
                Coffee espresso = new Espresso();
                System.out.println("Ingredients for Espresso: ");
                espresso.prepareCoffee();
                System.out.println("Price for Espresso: "+ espresso.getPrice());
                totalPriceOfOrder += order.get(s) * espresso.getPrice();
            }else if(s.equals("Cappuccino")){
                Coffee cappuccino = new Cappuccino();
                System.out.println("Ingredients for Cappuccino: ");
                cappuccino.prepareCoffee();
                System.out.println("Price for Cappuccino: "+ cappuccino.getPrice());
                totalPriceOfOrder += order.get(s) * cappuccino.getPrice();
            }
            else if(s.equals("Mocha")){
                Coffee mocha = new Mocha();
                System.out.println("Ingredients for Mocha: ");
                mocha.prepareCoffee();
                System.out.println("Price for Mocha: "+ mocha.getPrice());
                totalPriceOfOrder += order.get(s) * mocha.getPrice();
            }
        }

        if(hasOrdered)
            System.out.println("Total price of Your Order : " + totalPriceOfOrder);




    }
}
