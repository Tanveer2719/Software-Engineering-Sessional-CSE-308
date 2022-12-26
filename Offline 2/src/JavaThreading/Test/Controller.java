package JavaThreading.Test;

public class Controller implements Runnable{

    Message message;
    ChangeState changeState = new ChangeState();

    public Controller(Message message){
        this.message = message;
        new Thread(this).start();
    }

    @Override
    public void run() {

        Var.operational = true;
        System.out.println("Currently the Server is in operational state");
        int x = changeState.changeCurrentState();
        update_variables(x);
        message.sendNotification();


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