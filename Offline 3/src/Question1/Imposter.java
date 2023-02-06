package Question1;

public class Imposter implements ImposterInterface{
    @Override
    public void damage() {
        System.out.println("The imposter is damaging the SpaceShip now !!");
    }

    @Override
    public void kill() {
        System.out.println("The imposter has now added poison to the food of the CrewMate");
    }
}
