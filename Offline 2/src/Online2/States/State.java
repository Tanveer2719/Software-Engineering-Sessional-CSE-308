package Online2.States;

import Online2.Context;

public abstract class State {
    public static Context context;

    public static void setContext(Context x){
        context = x;
    }
    public abstract void print() throws InterruptedException;
}
