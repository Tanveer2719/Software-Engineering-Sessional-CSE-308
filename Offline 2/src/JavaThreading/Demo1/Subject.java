package JavaThreading.Demo1;

import java.util.LinkedList;
import java.util.List;

public class Subject implements SubjectInterface
{
    private boolean flag;

    List<MyInterface> users = new LinkedList<>();


    @Override
    public void registerUser(MyInterface x) {
        users.add(x);
    }

    @Override
    public void removeUser(MyInterface x) {
        users.remove(x);
    }

    @Override
    public void notifyAllObservers() {

    }
}
