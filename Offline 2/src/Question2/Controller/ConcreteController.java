package Question2.Controller;

import Question2.StaticVariables;
import Question2.Student.MyStudent;
import Question2.Teacher.MyTeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteController implements Controller{


    private List<MyStudent> registeredStudents = new ArrayList<>();
    private List<MyTeacher> teacherList = new ArrayList<>();
    private List<String>subjects = new ArrayList<>();
    Random random = new Random();

    private int subIndex;
    private int stdIndex;

    private boolean flag = false;
    private boolean exit = false;
    private boolean updateMarks = false;

    @Override
    public synchronized void run() {
        updateSubjectList();
        requestAnswerScriptsAndResult();
        // sendForScrutinizing();
        publishResult();
        askForReExamine();

        exitThreads();



    }

    private void updateSubjectList() {
        for(MyTeacher t: teacherList){
            subjects.add(t.getSubjectName());
        }

        for(MyStudent s :registeredStudents){
            s.setSubjectList(subjects);
        }
    }

    private void exitThreads() {
        for(MyTeacher t: teacherList){
            t.setExit();
            waiter();
        }

        for(MyStudent s: registeredStudents){
            s.setExit();
            waiter();
        }
    }

    @Override
    public void registerStudent(MyStudent s) {
        registeredStudents.add(s);
    }

    @Override
    public void registerTeacher(MyTeacher t) {
        teacherList.add(t);
    }

    @Override
    public void requestAnswerScriptsAndResult() {
        System.out.println("FROM CONTROLLER : Exam scripts and number list are requested from teachers");
        StaticVariables.sendScripts = true;
        for(MyTeacher x : teacherList){
            x.activator();
            waiter();
        }
        StaticVariables.sendScripts = false;
    }

    @Override
    public void sendForScrutinizing() {
        String idList = probableList();
        System.out.println("FROM CONTROLLER : Exam scripts of students with id " + idList + " again sent to the teacher after Scrutinizing");
        for(MyTeacher teacher: teacherList)
            teacher.receiveScrutinizingReq(idList);
    }

    @Override
    public void publishResult() {
        System.out.println("FROM CONTROLLER : Final result after Scrutinizing is published.");
        StaticVariables.publishResult = true;

        for(MyStudent x: registeredStudents){
            x.updateMarks();
        }

        for(MyStudent x : registeredStudents){
                x.activator();
                waiter();

        }

        StaticVariables.publishResult = false;

    }

    public void setIndex(int index) {
        this.subIndex = index;
    }

    @Override
    public void updateMarks() {
        updateMarks = true;
    }

    @Override
    public void sendForReExamine(int i) {
        for(MyTeacher teacher: teacherList){
            if(subjects.get(subIndex).equals(teacher.getSubjectName())){
                StaticVariables.sendForReExamine = true;
                System.out.println("(FROM CONTROLLER) :  Sending the Re Examine request of  (id -" + i + ") to " + teacher.getTeacherName());
                teacher.activator();
                break;
            }
            StaticVariables.sendForReExamine = false;
        }


    }

    @Override
    public void replyAfterReExamine(MyStudent x) {
        x.getReExamineResult(updateMarks);
        // waiter();
    }

    @Override
    public void askForReExamine() {
        for(MyStudent x : registeredStudents){
            StaticVariables.askForReExamine = true;
            x.activator();
            waiter();
            if(subIndex == -1) {
                System.out.println("(CONTROLLER) : You are not applying for reExamine");
                continue;    // the student does not want to reexamine so continue
            }
            sendForReExamine(x.getId());
            waiter();
            replyAfterReExamine(x);
        }
    }

    public synchronized void activator(){
        this.notify();
    }

    public void setExit(){
        exit = true;
        activator();
    }

    private void waiter(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String probableList(){
        int x = registeredStudents.size();  // find the size of the list
        x = (int)(x*0.6);       //set the no. of numbers to be generated
        List<Integer> temp = new ArrayList<>();


        while(temp.size()< x){
            int y = random.nextInt(x);
            if(! temp.contains(y)){
                temp.add(y);
            }
        }

        String idList = "";
        for(int i = 0;i<temp.size(); i++){
            idList += String.valueOf(registeredStudents.get(temp.get(i)));
        }

        return idList;
    }


}

/**
 * The teacher sends the number to the Controller "receiveAnswerScriptsAndResult()"
 * the Controller scrutinize the number calling method "sendForScrutinizing()" from the above method
 * If any discrepancy found then send again to the teacher by the method "sendForScrutinizing()"
 * "receiveAfterScrutinizing()" this method just ask the students to go to the website for the result
 *
 *
 */
