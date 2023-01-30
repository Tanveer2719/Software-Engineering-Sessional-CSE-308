package StrategyPrattern.DuckModels;

import StrategyPrattern.Flyable.FlyWithWings;
import StrategyPrattern.QuackAble.Quack;

public class MallardDuck extends Duck{

    public MallardDuck(){
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour((new Quack()));
    }
    @Override
    public void display() {
        System.out.println("This is a Mallard duck");
        getFlyBehaviour();
        getQuackBehaviour();
    }
}
