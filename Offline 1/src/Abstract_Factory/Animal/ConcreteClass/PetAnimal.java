package Abstract_Factory.Animal.ConcreteClass;


public class PetAnimal implements Animal {
    @Override
    public void preferredAction() {
        System.out.println("Pet dog found in : Houses");
    }

    @Override
    public void speak() {
        System.out.println("Pet dog speaks calmly : gheo gheo");
    }

    @Override
    public void print() {
        preferredAction();
        speak();
    }
}
