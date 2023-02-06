package Question1;

public class Demo {
    public static void main(String[] args) {
        Imposter imp1 = new Imposter();

        CrewMate crew1 = new CrewMate();

        /********** Now we are calling native methods to both imposter and crwMate **********/
        System.out.println("\nOriginal functionalities :");
        imp1.damage();
        imp1.kill();

        crew1.study();
        crew1.job();


        /*********** Now with the adapter the imposter is acting like a crewMate but performing like an imposter ***********/
        System.out.println("\nAfter using the adapter: ");
        ImposterAdapter adapter = new ImposterAdapter(imp1);
        adapter.study();
        adapter.job();
    }
}
