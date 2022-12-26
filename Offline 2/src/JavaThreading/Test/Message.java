package JavaThreading.Test;

import java.util.Scanner;

public class Message{
    Scanner scanner = new Scanner(System.in);

    synchronized void sendNotification(){
        while(! Var.controller){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(Var.partially_down){
            System.out.println("Our server is partially down now ");
            notifyAll();
        }
       else if(Var.operational){
            System.out.println("Our server is operational now");
            notifyAll();
        }
       else if(Var.fully_down){
            System.out.println("Our server is fully down now");
            notifyAll();
        }
    }

    synchronized void PartiallyDown(String code){

        while(! Var.partially_down){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        switch (code){
            case "prem":
            {
                System.out.println("You are now using service from two servers !!");
                Var.prem = false;
                Var.free = true;
                notifyAll();
                break;
            }
            case "free": {
                System.out.println("Do you want full service after paying 20$ ?");

                System.out.println("Press 1 for YES and 2 for NO");
                int x = scanner.nextInt();
                while(x < 1 && x > 2) {
                    System.out.println("Press 1 for YES and 2 for NO");
                    x = scanner.nextInt();
                }

                if(x == 1){
                    System.out.println("You have to pay 20$ and enjoy our full functionality");
                }
                else{
                    System.out.println("Okay...You will have partial functionality now !!!");
                }

                Var.free = false;
                Var.controller = true;
                notifyAll();

            }

        }

    }

    synchronized void fully_down(){

    }

    synchronized void operational(){

    }

}
