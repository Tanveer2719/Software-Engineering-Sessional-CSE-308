package Question1.Controller;

import Question1.Users.MyInterface;

public interface MySubject extends Runnable{
    void sendNotifications();
    void activator();
    void addPremiumUser(MyInterface x);
    void addFreeUser(MyInterface x);
    void removePremiumUser(MyInterface x);
    void removeFreeUser(MyInterface x);
}
