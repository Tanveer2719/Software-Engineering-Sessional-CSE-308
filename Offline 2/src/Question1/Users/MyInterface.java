package Question1.Users;

public interface MyInterface extends Runnable {
    void setExit();
    String getName();
    void update();
}

/**
 * This is a special interface that extends the runnable interface along with personal methods
 * the "setExit()" is used to break the while condition inside the run() method of the Premium and the Free class
 * "getName()" to get the name of the user
 * "update()" to notify the Premium and the Free class that the state is updated and they are given the chance to wake up and
 *            perform their respective task
 */
