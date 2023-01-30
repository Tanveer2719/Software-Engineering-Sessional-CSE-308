package StrategyPrattern.DuckModels;

import StrategyPrattern.Flyable.NoFlying;
import StrategyPrattern.QuackAble.Mute;

public class RubberDuck extends Duck{

    public RubberDuck(){
        this.setQuackBehaviour(new Mute());
        this.setFlyBehaviour(new NoFlying());
    }

    @Override
    public void display() {
        System.out.println("This is a Rubber Duck");
        getFlyBehaviour();
        getQuackBehaviour();
    }
}
