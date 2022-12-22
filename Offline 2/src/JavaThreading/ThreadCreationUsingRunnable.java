package JavaThreading;

class NewThread2 implements Runnable{
    Thread t;
    NewThread2(){
        t = new Thread(this);   // we always need to pass a class that implements runnable
                                    // since NewThread2 himself implements runnable so we pass this to the constructor
        t.start();
    }

    @Override
    public void run() {
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
public class ThreadCreationUsingRunnable {
    public static void main(String[] args) {
        new NewThread2();
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
