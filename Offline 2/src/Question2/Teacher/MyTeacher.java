package Question2.Teacher;

import java.util.List;
import java.util.Map;

public interface MyTeacher extends Runnable{
    String getSubjectName();
    String getTeacherName();
    void sendScriptsAndNumber();
    void receiveScrutinizingReq();
    void sendAfterScrutinizing();
    void receiveReExamineRequest();
    void sendAfterReExamine();
    void activator();
    void setExit();
    void setRawMarkSheet(List<Map<String, Integer>> x);
    void setStudentsId(List<Integer> x);
    void setStudentIdForReExamine(int x) ;




}
