package Question2.Teacher;

import Question2.Controller.Controller;
import Question2.StaticVariables;

import java.util.Random;

public class NewTeacher implements MyTeacher{

    private String name;
    private String subject;
    private Controller controller;

    private boolean flag = false;
    private boolean exit = false;
    private Random random = new Random();


    public NewTeacher(Controller controller, String name, String subject) {
        this.name = name;
        this.subject = subject;
        this.controller = controller;
        new Thread(this).start();
    }

    @Override
    public synchronized void run() {
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(!exit){
            if(StaticVariables.sendScripts){
                sendScriptsAndNumber();
                waiter();
            }
            else if(StaticVariables.sendForReExamine){
                receiveReExamineRequest();
                waiter();
            }


        }

        System.out.println("\n(Teacher: " + name + ") thread terminated");
        controller.activator();

    }

    @Override
    public String getSubjectName() {
        return subject;
    }

    @Override
    public String getTeacherName() {
        return name;
    }

    @Override
    public void sendScriptsAndNumber() {
        System.out.println("(FROM TEACHER) : " + name + ":  Scripts and number of " + subject + " sent to the Exam controller");
        controller.activator();

    }

    @Override
    public void receiveScrutinizingReq(String s) {

    }

    @Override
    public void sendAfterScrutinizing() {

    }

    @Override
    public void receiveReExamineRequest() {
        System.out.println("(FROM TEACHER): " + name + " : Re Examine is going on");
        sendAfterReExamine();
    }

    @Override
    public void sendAfterReExamine() {
        System.out.println("(FROM TEACHER): " + name + " : The Script and Re Examine result is sent to the controller");
        if(findProbability() == 1){
            // System.out.println("Result is updated");
            controller.updateMarks();
        }

        // StaticVariables.sendAfterReExamine = true;
        controller.activator();


    }
    public synchronized void activator(){
        flag = true;
        this.notify();
    }

    public void setExit(){
        exit = true;
        activator();
    }

    private synchronized void waiter(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int findProbability(){
        int a = random.nextInt(2);
        return a;

    }

}
