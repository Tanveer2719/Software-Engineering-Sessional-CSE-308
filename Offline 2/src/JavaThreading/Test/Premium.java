package JavaThreading.Test;

public class Premium implements Runnable {

    Message message;
    public Premium(Message message){
        this.message = message;
        new Thread(this).start();
    }

    @Override
    public synchronized void run() {
        message.PartiallyDown("prem");

    }
}
