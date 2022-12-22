package Question3;

import Question3.Models.State;
import Question3.StaticMethods.Product;
import Question3.StaticMethods.States;


public class Context {
    private State currentState;

    public Context(){
       if(Product.productCount > 0){
           currentState = States.hasProduct;
       }else{
           currentState = States.outOfProduct;
       }
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void startTheMachine(){
        currentState.execute();
    }

}
