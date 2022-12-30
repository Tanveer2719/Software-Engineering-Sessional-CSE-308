package Question2.Student;

import java.util.List;
import java.util.Map;

public interface MyStudent extends Runnable{
    String getName();
    int getId();
    void reExamine();
    void printResult();
    void activator();
    void setExit();
    void setSubjectList(List<String> a );
    void getReExamineResult(boolean x,Map<String, Integer> mp);
    void updateMarks(Map<String, Integer> mp);
}
