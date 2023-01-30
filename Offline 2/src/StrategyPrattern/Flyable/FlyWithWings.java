package StrategyPrattern.Flyable;

import StrategyPrattern.Flyable.FlyInterface;

public class FlyWithWings implements FlyInterface {

    @Override
    public void fly() {
        System.out.println("The duck flies with two wings at large");
    }
}
