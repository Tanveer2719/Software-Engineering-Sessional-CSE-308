package Abstract_Factory.Animal.Factory;

import Abstract_Factory.Animal.ConcreteClass.Animal;

public  class Factory {

    private FactoryDescription factory;
    private Animal animal;

    public void setFactory(int i){
        if (i == 1){
            factory = new PetAnimalFactory();
        }else  if(i == 2){
            factory = new WildAnimalFactory();
        }
    }


    public Animal getAnimal(int i) {
        if (i == 1){
            animal = factory.createDog();
        }else  if(i == 2){
            animal = factory.createTiger();
        }
        return animal;
    }
}
