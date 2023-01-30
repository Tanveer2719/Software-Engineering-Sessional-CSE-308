package StrategyPrattern.QuackAble;

public class Quack implements QuackInterface{
    @Override
    public void quack() {
        System.out.println("The duck Quacks");
    }
}
