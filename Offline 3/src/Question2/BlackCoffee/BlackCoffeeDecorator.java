package Question2.BlackCoffee;

import Question2.Coffee;

public class BlackCoffeeDecorator extends BlackCoffee {
    protected Coffee coffee;

    public BlackCoffeeDecorator(){
        coffee = new BlackCoffee();
    }

    public void prepareCoffee(){
        coffee.prepareCoffee();
    }



}
