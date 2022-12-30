package Question1.Helpers;

public class Var {
    // for state detection
    public static boolean partially_down = false;
    public static boolean operational = true;
    public static boolean fully_down = false;

    // if the free user pays or not
    public static boolean payment = false;

    // for detection of previous state
    public static String code = "";

}

/**
 * The variables will remain static all around the program
 * I took the help of the static states so that I can keep track of various states throughout the program
 *
 * Code is a special String type code that will help to identify the previous state and also the current state
 * According to the code and the state detecting variables I called various methods in the "Message" class from the "Premium" and the "Free" class
 *
 * of : operational -> fully down
 * op : operational -> partially down
 * fp : fully down -> partially down
 * fo : fully down -> operational
 * po : partially down -> operational
 * pf : partially down -> fully down
 *
 */
