package Question_2.Models;

public class Toyota extends Car {

    @Override
    public void create() {
        setName("Toyota");
        setColor("Red");
        setCountry("Japan");
        setEngineType("Hydrogen Fuel Cell");
        setDriveTrain("Rear Wheel");
    }
}
