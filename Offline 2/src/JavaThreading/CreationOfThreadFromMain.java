package JavaThreading;
class NewThread3 implements Runnable{
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
public class CreationOfThreadFromMain {
    public static void main(String[] args) {
        Thread t;
        Runnable r = new NewThread3();
        t = new Thread(r);
        t.start();

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
