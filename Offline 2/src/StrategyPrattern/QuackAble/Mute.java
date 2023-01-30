package StrategyPrattern.QuackAble;

public class Mute implements QuackInterface {
    @Override
    public void quack() {
        System.out.println("The duck is mute");
    }
}
