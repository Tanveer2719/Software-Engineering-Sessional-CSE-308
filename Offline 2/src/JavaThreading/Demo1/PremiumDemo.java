package JavaThreading.Demo1;

import static JavaThreading.Demo1.StaticClass.controller;

class PremiumUser implements MyInterface{
    String hello;
    boolean up = false;
    boolean exit = false;
    Controller control;


    @Override
    public synchronized void update(int x) {
        up = true;
        if(x == 1){
            hello = "x = 1";
        }else if (x == 2){
            hello = "x = 2";
        }else{
            hello = "x = 3";
            // this.notify();
        }

    }

    @Override
    public void setFlag(int x) {
    }

    @Override
    public void setExit() {
        exit = true;
    }

    @Override
    public synchronized void run() {
        System.out.println("Thread started");
        while(!exit) {
            if (up) {
                System.out.println(hello);
                up = false;
            }
        }
    }

    @Override
    public void setControl(Controller controller){
        control = controller;
    }

    @Override
    public Controller getControl(){
        return control;
    }

    void addUser(MyInterface r){
        control.addUser(r);
    }
}

public class PremiumDemo{
    public static void main(String[] args) {
        PremiumUser r1 = new PremiumUser();
        Thread t1 = new Thread(r1);
        t1.start();
        controller.addUser(r1);

    }
}
