package Question_2.Models;

public class Tesla extends Car{

    @Override
    public void create() {
        setName("Tesla");
        setColor("White");
        setCountry("United States");
        setDriveTrain("Electric");
        setEngineType("All Wheels");

    }
}
