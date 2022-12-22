package Abstract_Factory.Animal.ConcreteClass;

public class WildTiger implements Animal {
    @Override
    public void preferredAction() {
        System.out.println("Wild tiger found in Wild forests");
    }

    @Override
    public void speak() {
        System.out.println("Wild tiger loudly speaks : Halum");
    }

    @Override
    public void print() {
        speak();
        preferredAction();
    }
}
