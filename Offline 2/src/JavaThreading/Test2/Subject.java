package JavaThreading.Test2;

import java.util.LinkedList;
import java.util.List;

class SubjectClass{

    public List<ObserverClass> users = new LinkedList<>();

    public void sendNotifications(){
        for(ObserverClass a : users )
            a.update();
    }


}

public class Subject {

}
