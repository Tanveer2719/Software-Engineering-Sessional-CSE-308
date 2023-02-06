package Question1;

public class CrewMate implements CrewMateInterface{
    @Override
    public void study() {
        System.out.println("The crewMate is studying the interstellar object ");
    }

    @Override
    public void job() {
        System.out.println("The crewMate is now performing maintenance job of the spaceShip");
    }
}
