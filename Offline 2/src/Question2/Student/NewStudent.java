package Question2.Student;

import Question2.Controller.Controller;
import Question2.StaticVariables;

import java.util.*;

public class NewStudent implements MyStudent{

    private String name;
    private String id;
    private Controller controller;

    private List<String> subjects;
    private List<Map<String, Integer>> marks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private boolean flag = false;
    private boolean exit = false;

    private boolean marksImproved = false;
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
        System.out.println("Student : " + name + " , id : " + id + " thread terminated");
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
    public void getReExamineResult(boolean value) {
        if(!value){
            System.out.println("Marks of " + subject + " is not increased after Re Examine");
        }
        else{
            Map<String, Integer> mp = new HashMap<>();
            int x;
            for(int i = 0; i<marks.size(); i++) {
                if (marks.get(i).containsKey(subject)) {
                    mp = marks.get(i);
                    x = marks.get(i).get(subject);
                    x = random.nextInt(x + 1, 101);
                    marks.get(i).put(subject, x);
                    break;
                }
            }

            printHeader();
            System.out.println("New Marks: ");
            System.out.println("{Subject=Marks}");
            for(Map<String , Integer> map : marks){
                System.out.println(map.toString());
            }
        }
    }

    @Override
    public void updateMarks() {
        for(String x: subjects){
            Map<String, Integer> mp = new HashMap<>();
            mp.put(x, random.nextInt(40, 100));
            marks.add(mp);
        }
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
        System.out.println("{Subject=Marks}");
        for(Map<String , Integer> x : marks){
            System.out.println(x.toString());
        }
        controller.activator();

    }


}
