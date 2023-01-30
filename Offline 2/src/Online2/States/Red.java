package Online2.States;

import Online2.StaticClass;

public class Red extends State {
    @Override
    public void print() throws InterruptedException {
        System.out.println("The color of the light is red now");
        Thread.sleep(5000);
        context.setCurrentState(StaticClass.yellow);
        context.getCurrentState().print();
    }
}
