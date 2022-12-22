package Abstract_Factory.Animal.Factory;

import Abstract_Factory.Animal.ConcreteClass.Animal;

public interface FactoryDescription {
     Animal createDog();
     Animal createTiger();
}
