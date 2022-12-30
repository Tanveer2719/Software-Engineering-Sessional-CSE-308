package Question2.Controller;

import Question2.StaticVariables;
import Question2.Student.MyStudent;
import Question2.Teacher.MyTeacher;

import java.util.*;

public class ConcreteController implements Controller{

    private List<MyStudent> registeredStudents = new ArrayList<>();
    private List<MyTeacher> teacherList = new ArrayList<>();
    private List<String>subjects = new ArrayList<>();
    private List<Map<String, Integer>> marks = new ArrayList<>();
    Random random = new Random();

    private int subIndex;

    private boolean flag = false;
    private boolean exit = false;
    private boolean updateMarks = false;

    @Override
    public synchronized void run() {
        updateSubjectList();
        requestAnswerScriptsAndResult();
        sendForScrutinizing();
        publishResult();
        askForReExamine();
        finalMessage();

        exitThreads();
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
        System.out.println("(FROM CONTROLLER) : Exam scripts and number list are requested from teachers");
        StaticVariables.sendScripts = true;
        for(MyTeacher x : teacherList){
            x.activator();
            waiter();
        }
        StaticVariables.sendScripts = false;

        createMarkSheet();
    }

    @Override
    public void sendForScrutinizing() {
        for(MyTeacher teacher: teacherList)
            teacher.setRawMarkSheet(marks);

        StaticVariables.scrutinize = true;
        Map<String, ArrayList<Integer>> probableList = probableListForScrutinizing();

        for(String sub: probableList.keySet()){
            MyTeacher teacher = teacherList.get(subjects.indexOf(sub));
            teacher.setStudentsId(probableList.get(sub));
            teacher.activator();
            waiter();
        }

        StaticVariables.scrutinize = false;
    }

    @Override
    public void publishResult() {
        System.out.println("\n(FROM CONTROLLER) : Final result after Scrutinizing is published.");
        StaticVariables.publishResult = true;

        for(int i = 0;i <registeredStudents.size();i++){
            registeredStudents.get(i).updateMarks(marks.get(i));
            registeredStudents.get(i).activator();
            waiter();
        }

        StaticVariables.publishResult = false;

    }

    public void setIndex(int index) {
        this.subIndex = index;
    }

    @Override
    public void setUpdate() {
        updateMarks = true;
    }

    @Override
    public void setMarkSheet(List<Map<String, Integer>> markSheet) {
        marks = markSheet;
    }

    @Override
    public void sendForReExamine(int i) {
        for(MyTeacher teacher: teacherList){
            if(subjects.get(subIndex).equals(teacher.getSubjectName())){
                StaticVariables.sendForReExamine = true;
                System.out.println("(FROM CONTROLLER) :  Sending the Re Examine request of  (id -" + i + ") to " + teacher.getTeacherName());
                teacher.setStudentIdForReExamine(i);
                teacher.activator();
                break;
            }
            StaticVariables.sendForReExamine = false;
        }


    }

    @Override
    public void replyAfterReExamine(int id) {
        registeredStudents.get(id-1).getReExamineResult(updateMarks,marks.get(id-1));
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
            replyAfterReExamine(x.getId());
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

    private Map<String, ArrayList<Integer>> probableListForScrutinizing(){
        int x = registeredStudents.size();  // find the size of the list
        int sub = subjects.size();
        x = (int)(x*0.6);       //set the no. of numbers to be generated
        int i = 0;
        Map<String, ArrayList<Integer>> studentIdAndSubject = new HashMap<>();

        // we have assumed that the controller sends only one script of the student for scrutinizing
        while(i < x){
            int id = random.nextInt(x);
            int sid = random.nextInt(sub);
            if(! studentIdAndSubject.containsKey(subjects.get(sid))){
                studentIdAndSubject.put(subjects.get(sid) , new ArrayList<>());
                studentIdAndSubject.get(subjects.get(sid)).add(id+1);
            }
            else if(! studentIdAndSubject.get(subjects.get(sid)).contains(id+1)){
                studentIdAndSubject.get(subjects.get(sid)).add(id+1);
            }
            i++;
        }

        return studentIdAndSubject;
    }

    private void createMarkSheet(){
        System.out.println("\n(Controller) : The given markSheet by teachers :  ");
        for(int i = 0; i<registeredStudents.size(); i++) {
            Map<String, Integer> mp = new HashMap<>();
            for (String x : subjects) {
                mp.put(x, random.nextInt(40, 100));
            }
            marks.add(mp);
        }
        printResult();
    }

    private void printResult() {
        for(int i = 0; i<registeredStudents.size(); i++){
            System.out.println(registeredStudents.get(i).getName() + " -> " + marks.get(i).toString());
        }
    }

    private void finalMessage() {
        System.out.println("\n(FROM CONTROLLER: ) Our final result Table: ");
        printResult();
        System.out.println("\n(FROM CONTROLLER: ) Thank you all for your support. Best of luck for next Semester !!!");
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

}

/**
 * registeredStudents -> Students list for the controller
 * teacherList -> Teachers list for the controller
 * subjects -> List of subjects that the teachers teach
 * marks -> An arraylist that contains marks for all the registered students like --- "<Subject name , Marks>"
 * subIndex -> in case of ReExamine the Student sends a subject index to the Controller after selecting which subject he wants to reexamine
 * flag ,exit -> for thread controlling
 * updateMarks -> if the marks after reExamine is updated for a student then the Teacher sets the updateMarks flag = true
 * registerStudent, teacher() -> adding student and teacher to the respective list
 * requestAnswerScriptsAndResult() -> Requests each registered teacher to send the scripts and the result
 * createMarkSheet() -> this method updates the "marks" arrayList with random marks for each subject for each student
 * sendForScrutinizing() -> sends a list of student id's chosen at random to the respective subject Teachers so that The teacher can update the
 *                          marks of that student at random
 * probableListForScrutinizing() -> The method used by sendForScrutinizing() to create a mapping of "<Subject_name, List of Student_id>"
 * publishResult() -> prompts each student to print his individual mark sheet after Scrutinizing
 * setIndex() -> for setting the subject Index (subIndex)
 * setUpdate() -> update the updateMarks flag
 * setMarkSheet() -> set the marks after scrutinizing and reExamining from the Teacher class
 * askForReExamine() -> it actually asks each user if they want to reExamine or not
 *                      the returned value sets the subIndex and based on the value we take decision if we want to reExamine or not
 *                      and call the methods ---> sendForReExamine(), replyAfterReExamine()
 * sendForReExamine() -> this method calls the subject Teacher of the subject indicated by subIndex and asks the teacher to perform
 *                      reExamine i.e. update the marks if Possible
 * replyAfterReExamine() -> prompt the required student about the reExamine result and if his marks is updated or not
 * activator(), waiter(), setExit() --> for thread controlling purpose
 * printResult() -> It actually prints the <marks> list
 * updateSubjectList() -> Just updating the <subjects> arraylist from the <teachers> arraylist
 * exitThread() -> for exiting the whole system
 * finalMessage() -> just print the final updated result and a concluding message
 *
 */
