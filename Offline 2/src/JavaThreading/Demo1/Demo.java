package JavaThreading.Demo1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static JavaThreading.Demo1.StaticClass.controller;

class Controller{
    private List<MyInterface> users = new LinkedList<>();


    public Controller(){
    }

    public Controller getController(){
        return this;
    }
    public void addUser(MyInterface a){
        a.setControl(this);
        users.add(a);
    }
    public void removeUser(MyInterface a){
        users.remove(a);
    }

    public List<MyInterface> getUsers(){
        return users;
    }

}

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("enter : ");
            int x = scanner.nextInt();
            System.out.println(controller.getUsers().size());

        }

    }
}
