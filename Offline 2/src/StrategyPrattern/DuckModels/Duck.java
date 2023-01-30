package StrategyPrattern.DuckModels;

import StrategyPrattern.Flyable.FlyInterface;
import StrategyPrattern.Flyable.FlyWithWings;
import StrategyPrattern.QuackAble.Mute;
import StrategyPrattern.QuackAble.QuackInterface;

public abstract class Duck {
    FlyInterface flyBehaviour;
    QuackInterface quackBehaviour;

    public Duck(){
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Mute();
    }

    public void getFlyBehaviour(){
        flyBehaviour.fly();
    }
    public void getQuackBehaviour(){
        quackBehaviour.quack();
    }
    public void setFlyBehaviour(FlyInterface f){
        flyBehaviour = f;
    }
    public void setQuackBehaviour(QuackInterface q){
        quackBehaviour = q;
    }

    public abstract void display();


}
