package StrategyPrattern;

import StrategyPrattern.DuckModels.Duck;
import StrategyPrattern.DuckModels.MallardDuck;
import StrategyPrattern.DuckModels.RubberDuck;

public class Demo {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();

        mallardDuck.display();

        System.out.println();

        rubberDuck.display();
    }
}
