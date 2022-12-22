package Abstract_Factory.Animal.ConcreteClass;

public class PetTiger implements Animal {
    @Override
    public void preferredAction() {
        System.out.println("Pet tiger found in Circus");
    }

    @Override
    public void speak() {
        System.out.println("pet tiger calmly speaks : Halum");
    }

    @Override
    public void print() {
        speak();
        preferredAction();
    }
}
