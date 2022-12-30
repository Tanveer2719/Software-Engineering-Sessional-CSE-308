package Question2.Teacher;

import Question2.Controller.Controller;
import Question2.StaticVariables;

import java.util.*;

public class NewTeacher implements MyTeacher{

    private String name;
    private String subject;
    private Controller controller;
    private List<Map<String, Integer>> markSheet = new ArrayList<>();   //total markSheet of the students
    private List<Integer> studentsId = new ArrayList<>();
    private int idForReExamine;

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
            }else if(StaticVariables.scrutinize){
                receiveScrutinizingReq();
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
        System.out.println("(FROM TEACHER) : " + name + ":  Scripts and number of " + subject.toUpperCase() + " sent to the Exam controller");
        controller.activator();

    }

    @Override
    public void receiveScrutinizingReq() {
        System.out.println("\n(Teacher) : " + name + " got scrutinizing request for Student id + : " + studentsId.toString());
        for(int i : studentsId)
            updateMarks(i-1);

        sendAfterScrutinizing();
    }

    private void updateMarks(int i) {
        Map<String, Integer> map = markSheet.get(i);
        map = markSheet.get(i);
        int x = markSheet.get(i).get(subject);
        x = random.nextInt(x + 1, 101);
        markSheet.get(i).put(subject, x);

    }

    @Override
    public void sendAfterScrutinizing() {
        controller.setMarkSheet(markSheet);
        controller.activator();

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
            if(markSheet.get(idForReExamine -1).containsKey(subject)){
                int x = markSheet.get(idForReExamine -1).get(subject);
                x = random.nextInt(x + 1, 101);
                markSheet.get(idForReExamine -1).put(subject, x);
            }
            controller.setUpdate();
            controller.setMarkSheet(markSheet);

        }
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

    @Override
    public void setRawMarkSheet(List<Map<String, Integer>> x) {
        markSheet = x;
    }

    @Override
    public void setStudentsId(List<Integer> x) {
        this.studentsId = x;
    }

    @Override
    public void setStudentIdForReExamine(int x) {
        idForReExamine = x;
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


/**
 * name, subject, controller -> name of the teacher, what he teaches, and an instance of the controller
 * markSheet -> The complete markSheet that will be updated during scrutinizing and reExamining
 * studentsId -> students whose scripts sent by the controller for scrutinizing
 * idForReExamine -> student id that asks for ReExamine the subject script
 * flag, exit, setExit(), waiter(), activator() ---> for thread controlling purpose
 * sendScriptsAndNumber() -> does nothing but prints a string that the marks are sent to the controller
 * receiveScrutinizingReq() -> called from the controller and the Teacher update the marks for each student in <studentId>
 * updateMarks() -> updates the mark in the <markSheet> for a student
 * sendAfterScrutinizing() -> updates the mark Sheet of the controller by calling a method and awakes the controller
 * receiveReExamineRequest() -> controller calls it to send reExamine request
 * sendAfterReExamine() -> The <markSheet> is reUpdated after the reExamine request if the probability agrees
 *                      -> updates the mark sheet of the controller and awakes controller
 * setRawMarkSheet() -> sets The <markSheet>
 * setStudentIdForReExamine -> set <studentsId>
 * findProbability() -> finds a probability that the student's mark will be updated after reExamine
 *
 *
 */