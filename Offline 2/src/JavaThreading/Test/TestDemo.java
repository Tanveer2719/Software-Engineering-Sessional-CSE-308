package JavaThreading.Test;

public class TestDemo {
    public static void main(String[] args) {
        Message message = new Message();

        new Premium(message);
        new Free(message);

        Var.controller = true;
        new Controller(message);



    }


}
