package Question1.Users;

import Question1.Controller.Controller;
import Question1.Helpers.Message;

import static Question1.Helpers.Var.*;

public class Free implements MyInterface {
    private String name;
    private boolean flag = false;
    private boolean exit = false;

    Controller control;
    Message message;
    public Free(Controller control, Message message,String name){
        this.control = control;
        this.message = message;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public synchronized void run() {
        while(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(!exit) {

            if (partially_down && code.equals("op")) {
                message.PartiallyDownFromOperational("free", name);
                waiter();
            } else if (fully_down && code.equals("of")) {
                message.FullyDownFromOperational("free", name);
                waiter();
            } else if (operational && code.equals("po")) {
                // System.out.println("now in free user ");
                message.operationalFromPartiallyDown("free", name);
                waiter();
            }else if(operational && code.equals("fo")){
                message.operationalFromFullyDown("free", name);
                waiter();
            }else if(fully_down && code.equals("pf")){
                message.fullyDownFromPartiallyDown("free", name);
                waiter();
            }else if(partially_down && code.equals("fp")){
                message.partiallyDownFromFullyDown("free", name);
                waiter();
            }
        }
        System.out.println("Exiting free user service for "+ name);
        control.activator();

    }
    public synchronized void setExit(){
        exit = true;
        update();
    }
    private synchronized  void waiter(){
        flag = false;
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String  getName() {
        return name;
    }

    @Override
    public synchronized void update() {
        flag = true;
        this.notify();
    }
}
/**
 * exit -> for proper ending of the while loop
 * flag -> to keep the thread at bay at the very first time
 * In the run method we have used the static variables and the static code to call the required message method and then
 *                   made our thread wait by calling the waiter method
 *                   At the end the "control.activator()" is called to activate the controller after the completion of the
 *                   while loop
 *
 * waiter() -> just used to make the current thread
 * update() -> used to awake and activate current thread
 * setExit() -> used to set the exit flag true
 */