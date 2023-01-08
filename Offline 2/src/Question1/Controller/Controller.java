package Question1.Controller;

import Question1.Helpers.Message;
import Question1.Users.MyInterface;
import Question1.Helpers.Var;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static Question1.Helpers.Var.*;

public class Controller implements MySubject{

    Message message;
    ChangeState changeState = new ChangeState();
    Scanner scanner = new Scanner(System.in);
    private List<MyInterface> premiumUsers = new LinkedList<>();
    private List<MyInterface> freeUsers = new LinkedList<>();



    public Controller(Message message){
        this.message = message;
        this.message.setController(this);
        Var.operational = true;
    }

    @Override
    public synchronized void run() {
        System.out.println("Currently in OPERATIONAL STATE");
        while(true) {
            System.out.println("\n***** Controller *****");
            System.out.println("Press 1 to exit...else continue");
            String a = scanner.next();
            if(a.equals("1")){
                quitThreads();
                break;
            }
            int x = changeState.changeCurrentState();
            update_variables(x);

            // send notifications to all the premium and free users
            sendNotifications();
        }
        System.out.println("Exiting controller and all other services");
    }

    @Override
    public synchronized void sendNotifications(){
        if(partially_down){
            System.out.println("CONTROLLER : Our server is partially down now ");
            updateUsers();
        }
        else if(operational){
            System.out.println("CONTROLLER : Our server is operational now");
            updateUsers();

        }
        else if(fully_down){
            System.out.println("CONTROLLER : Our server is fully down now");
            updateUsers();
        }
    }

    @Override
    public synchronized void activator(){
        this.notify();
    }

    @Override
    public void addPremiumUser(MyInterface x){
        premiumUsers.add(x);
    }

    @Override
    public void addFreeUser(MyInterface x){
        freeUsers.add(x);
    }

    @Override
    public void removePremiumUser(MyInterface x){
        premiumUsers.remove(x);
    }

    @Override
    public void removeFreeUser(MyInterface x){
        freeUsers.remove(x);
    }

    private synchronized void quitThreads(){
        for(MyInterface x: premiumUsers){
            x.setExit();
            waiter();
        }
        for(MyInterface x: freeUsers){
            x.setExit();
            waiter();
        }
    }

    private synchronized void updateUsers(){
        for(MyInterface x: premiumUsers){
            x.update();
            waiter();
        }
        for(MyInterface x: freeUsers){
            x.update();
            waiter();
        }

    }

    private synchronized void waiter(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update_variables(int x) {
        if(x == 1){
            Var.operational = true;
            Var.partially_down = false;
            Var.fully_down = false;
        }
        else if (x == 2){
            Var.operational = false;
            Var.partially_down = true;
            Var.fully_down = false;
        }else{
            Var.operational = false;
            Var.partially_down = false;
            Var.fully_down = true;
        }
    }
}

/**
 * A list of premium and free users is maintained
 * adder and remover methods are at below
 *
 * ChangeState is a helper class helps to change the current state based on the Static variables
 *
 * waiter and activator methods are to make the thread wait and activate respectively
 * sendNotifications() -> After change of state occurs we need to notify the users. So the sendNotifications called
 * updateUsers() ->  this method actually loops through the users list and then call the update method of respective user
 * updateVariables() -> "changeState.changeCurrentState()" sends an integer. This method changes the Static flags based on that
 *                         Integer. Necessary for the calling of necessary method in the Premium and Free class
 *
 * quitThreads() -> when the user press 1 then quitThread is called to exit all the running threads by setting exitFlag = true
 *
 *
 */