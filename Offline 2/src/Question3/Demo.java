package Question3;

import Question3.Models.State;

public class Demo {
    public static void main(String[] args) {
        Context context = new Context();
        State.setContext(context);
        context.startTheMachine();
    }
}
