package JavaThreading.Test;

public class Free implements Runnable {

    Message message;
    public Free(Message message){
        this.message = message;
        new Thread(this).start();
    }

    @Override
    public synchronized void run() {

        message.PartiallyDown("free");

    }

}