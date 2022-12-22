package JavaThreading;

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("The name of the thread is " + t);

        t.setName("Demo");
        System.out.println("The changed name is : " + t );

        try{
            for(int i = 0;i<5;i++){
                System.out.println(i);
                Thread.sleep(1000);
            }

        }catch (InterruptedException e){
            System.out.println("Interrupted exception");
        }
    }

}
