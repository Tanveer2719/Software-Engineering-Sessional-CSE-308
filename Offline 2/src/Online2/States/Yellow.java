package Online2.States;

import Online2.States.State;
import Online2.StaticClass;

public class Yellow extends State {
    @Override
    public void print() throws InterruptedException {
        System.out.println("The color is yellow now");
        Thread.sleep(2000);
        context.setCurrentState(StaticClass.green);
        context.getCurrentState().print();
    }
}
