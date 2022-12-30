package Question2.Teacher;

public interface MyTeacher extends Runnable{
    String getSubjectName();
    String getTeacherName();
    void sendScriptsAndNumber();
    void receiveScrutinizingReq(String s);
    void sendAfterScrutinizing();
    void receiveReExamineRequest();
    void sendAfterReExamine();
    void activator();
    void setExit();


}
