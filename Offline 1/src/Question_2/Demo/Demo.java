package Question_2.Demo;

import Question_2.Factory.CarFactory;
import Question_2.Models.Car;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // a scanner object to take input from the user

        System.out.println("Enter Your continental Location please: ");
        String continent = scanner.nextLine();

        //create a carFactory object for logical selection of cars
        CarFactory carFactory = new CarFactory();

        // get car from the factory
        Car car = carFactory.getCar(continent);
        if(car == null){
            System.out.println("Sorry...we have no car for your location !!!");
        }
        else {
            car.create();
            car.printCar();
        }


    }
}
