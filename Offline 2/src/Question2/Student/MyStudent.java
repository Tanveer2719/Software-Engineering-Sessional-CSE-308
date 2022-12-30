package Question2.Student;

import java.util.List;

public interface MyStudent extends Runnable{
    String getName();
    int getId();
    void reExamine();
    void printResult();
    void activator();
    void setExit();
    void setSubjectList(List<String> a );
    void getReExamineResult(boolean x);
    void updateMarks();
}
