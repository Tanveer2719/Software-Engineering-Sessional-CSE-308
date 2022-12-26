package JavaThreading.Test;

public class Var {
    // these three variables for controlling the thread
    public static boolean free = false;
    public static boolean prem = false;
    public static boolean controller = false;

    // for state detection
    public static boolean partially_down = false;
    public static boolean operational = true;
    public static boolean fully_down = false;

    // if the free user pays or not
    public static boolean payment = false;

    // for detection of previous state
    public static String code = "";

}
