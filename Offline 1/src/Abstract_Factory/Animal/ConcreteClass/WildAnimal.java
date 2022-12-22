package Abstract_Factory.Animal.ConcreteClass;

public class WildAnimal implements Animal {
    @Override
    public void preferredAction() {
        System.out.println("Wild dog found in : Roads");
    }

    @Override
    public void speak() {
        System.out.println("Wild dog speaks loudly : gheo gheo");
    }

    @Override
    public void print() {
        preferredAction();
        speak();
    }
}
