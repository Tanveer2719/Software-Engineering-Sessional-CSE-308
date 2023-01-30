package Online2;

import Online2.States.State;

public class Context {
    private State currentState;

    public Context(){
        currentState = StaticClass.red;
    }

    public void setCurrentState(State c){
        currentState = c;
    }
    public State getCurrentState(){
        return currentState;
    }

    public void startTheMachine() {
        try {
            currentState.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
