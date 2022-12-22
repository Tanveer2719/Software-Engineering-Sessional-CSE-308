package Abstract_Factory.Animal.Demo;

import Abstract_Factory.Animal.ConcreteClass.Animal;
import Abstract_Factory.Animal.Factory.Factory;

import java.util.Scanner;

public class AbstractFactoryExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*********FACTORY EXAMPLE***********");
        int idx;
        System.out.println("Press 1 for Pet \nPress 2 for Wild");
        idx = scanner.nextInt();

        Factory myFactory = new Factory();
        myFactory.setFactory(idx);

        System.out.println("Press 1 for a Dog \nPress 2 for a Tiger");
        idx = scanner.nextInt();

        Animal myAnimal = myFactory.getAnimal(idx);
        myAnimal.print();

    }
}
