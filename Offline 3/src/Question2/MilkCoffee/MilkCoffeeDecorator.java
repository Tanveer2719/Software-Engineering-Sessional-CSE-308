package Question2.MilkCoffee;

import Question2.Coffee;

public class MilkCoffeeDecorator extends MilkCoffee{
    protected Coffee coffee;

    public MilkCoffeeDecorator(){
        this.coffee = new MilkCoffee();
    }

    @Override
    public void prepareCoffee() {
        coffee.prepareCoffee();
    }


}
