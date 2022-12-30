package JavaThreading.Demo1;

public interface SubjectInterface {
    void registerUser(MyInterface x);
    void removeUser(MyInterface x);
    void notifyAllObservers();
}
