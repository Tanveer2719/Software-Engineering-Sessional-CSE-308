package Question1;

import Question1.Controller.Controller;
import Question1.Helpers.Message;
import Question1.Users.Free;
import Question1.Users.MyInterface;
import Question1.Users.Premium;

public class TestDemo {
    public static void main(String[] args) {
        Message message = new Message();
        Controller control = new Controller(message);

        MyInterface premium1 = new Premium(control, message, "Kamal");
        MyInterface free1 = new Free(control, message,"Hasan");


        control.addFreeUser(free1);
        control.addPremiumUser(premium1);
        new Thread(control).start();


    }


}
