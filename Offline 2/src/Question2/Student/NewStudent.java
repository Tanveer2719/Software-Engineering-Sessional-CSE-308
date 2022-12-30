package Question2.Student;

import Question2.Controller.Controller;
import Question2.StaticVariables;

import java.util.*;

public class NewStudent implements MyStudent{

    private String name;
    private String id;
    private Controller controller;

    private List<String> subjects;
    private Map<String, Integer> markSheet = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private boolean flag = false;
    private boolean exit = false;

    private String subject;

    public NewStudent(Controller controller, String name, String id){
        this.controller = controller;
        this.name = name;
        this.id = id;
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
            if(StaticVariables.publishResult){
                printResult();
                waiter();
            }else if(StaticVariables.askForReExamine){
                reExamine();
                waiter();
            }

        }
        System.out.println("\nStudent : " + name + " , id : " + id + " thread terminated");
        controller.activator();

    }

    private void printHeader() {
        System.out.println("\n****** Student name : " + name + " | Student id : " + id + " *******");
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

    @Override
    public void setSubjectList(List<String> a) {
        subjects = a;
    }

    @Override
    public void getReExamineResult(boolean value, Map<String, Integer> mp) {
        if(!value){
            System.out.println("Marks of " + subject + " is not increased after Re Examine");
        }
        else{
            markSheet = mp;
            printHeader();
            System.out.println("New Marks after Re Examine: ");
            System.out.println(markSheet.toString());
        }
    }

    @Override
    public void updateMarks(Map<String, Integer> mp) {
        markSheet = mp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return Integer.parseInt(id);
    }

    @Override
    public void reExamine() {
        printHeader();

        System.out.println("Do you want to reExamine your Script ?");
        System.out.println("1. Yes\n2. No");

        int x = scanner.nextInt();
        while(x > 2 || x < 1){
            System.out.println("Enter a valid number" );
            x = scanner.nextInt();
        }

        // we set the flag false to avoid repetition
        if(x == 2){
            controller.setIndex(-1);
        }else{
            System.out.println("Which subject do you want to Re Examine ? ");
            int i  = 1;
            for(String s : subjects){
                System.out.println(i + " . " + s);
                i++;
            }

            int y = scanner.nextInt();
            while(y > i || y < 1){
                System.out.println("Enter a valid number" );
                y = scanner.nextInt();
            }

            subject = subjects.get(y-1);
            System.out.println("Request sent to the controller for ReExamine the script:  " + subjects.get(y-1));
            controller.setIndex(y-1);
        }
        StaticVariables.askForReExamine = false; // we set the flag false to avoid repetition
        controller.activator();
    }

    @Override
    public void printResult() {
        printHeader();
        System.out.println(markSheet.toString());

        controller.activator();

    }


}

/**
 * name, id, controller -> name of the student, his id, and an instance of the controller
 * getName(), getId() -> getter methods
 * flag, exit, setExit(), waiter(), activator() ---> for thread controlling purpose
 * subjects -> List of subjects that are taught by the teachers
 * markSheet -> individual markSheet for each student
 * subject -> it is for the subject that is selected by the student for reExamine
 * printHeader() -> just to print a line that contains the student name and student id
 * setSubjectList() -> sets <subjects>
 * reExamine() -> called by the Controller to know if the Student wants to reExamine or not
 * getReExamineResult() -> prints the ReExamine result received from the controller
 * updateMarks() -> It is called by the controller to update the marks after the reExamine
 * printResult() -> just prints the individual markSheet
 *
 */
