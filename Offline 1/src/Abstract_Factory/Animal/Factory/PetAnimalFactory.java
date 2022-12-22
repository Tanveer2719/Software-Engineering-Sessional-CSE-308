package Abstract_Factory.Animal.Factory;

import Abstract_Factory.Animal.ConcreteClass.Animal;
import Abstract_Factory.Animal.ConcreteClass.PetAnimal;
import Abstract_Factory.Animal.ConcreteClass.PetTiger;

public class PetAnimalFactory implements FactoryDescription{

    @Override
    public Animal createDog() {
        return new PetAnimal();
    }

    @Override
    public Animal createTiger() {
        return new PetTiger();
    }
}
