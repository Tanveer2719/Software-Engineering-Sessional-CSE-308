package Online2;

import Online2.States.Green;
import Online2.States.Red;
import Online2.States.State;
import Online2.States.Yellow;

public class StaticClass {
    public static State red = new Red();
    public static State green = new Green();
    public static State yellow = new Yellow();
}
