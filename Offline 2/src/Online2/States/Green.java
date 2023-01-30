package Online2.States;

import Online2.StaticClass;

public class Green extends State {
    @Override
    public void print() throws InterruptedException {
        System.out.println("The color of the light is green now");
        Thread.sleep(10000);
        context.setCurrentState(StaticClass.red);
        context.getCurrentState().print();
    }
}
