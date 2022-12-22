package JavaThreading;

class NewThread extends Thread{
    NewThread(){
        super("New Thread");
        start();    // this indicates the start of the new thread. When this method called the thread will be active and running
    }

    // This is a method called automatically when a thread starts. The OS calls the run method when any thread starts
    // So we dont need to call the run method explicitly
    // We do all the coding for a certain thread inside the run method. It is like the main() method of the thread
    // we can call functions from here
    public void run(){
        for(int i = 0;i<5; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Exiting child thread");
    }
}
public class CreationOfNewThread {
    public static void main(String[] args) {
        new NewThread();    // this is enough to declare the start of the child thread
        for(int i = 0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting main thread");

    }
}
