package Online2;

import Online2.States.State;

public class Demo {
    public static void main(String[] args) {
        Context context = new Context();
        State.setContext(context);
        context.startTheMachine();
    }
}
