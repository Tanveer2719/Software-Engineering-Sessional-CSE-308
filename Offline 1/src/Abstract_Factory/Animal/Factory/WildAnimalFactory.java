package Abstract_Factory.Animal.Factory;

import Abstract_Factory.Animal.ConcreteClass.Animal;
import Abstract_Factory.Animal.ConcreteClass.WildAnimal;
import Abstract_Factory.Animal.ConcreteClass.WildTiger;

public class WildAnimalFactory implements FactoryDescription{
    @Override
    public Animal createDog() {
        return new WildAnimal();
    }

    @Override
    public Animal createTiger() {
        return new WildTiger();
    }
}
