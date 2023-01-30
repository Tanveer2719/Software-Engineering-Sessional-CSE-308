package StrategyPrattern.Flyable;

import StrategyPrattern.Flyable.FlyInterface;

public class NoFlying implements FlyInterface {
    @Override
    public void fly() {
        System.out.println("The duck does not fly");
    }
}
