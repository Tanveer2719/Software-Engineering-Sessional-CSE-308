package JavaThreading.Test2;

class ObserverClass{

    public void update(){

        System.out.println("Updated values");

    }

}
public class Observer {
    public static void main(String[] args) {
        SubjectClass s1 = new SubjectClass();
        ObserverClass o1 = new ObserverClass();
        s1.users.add(o1);
    }

}


/**
 * I shall create an observerClass and a subjectClass form the main method. add the observerClass to the subject's list
 *
 */