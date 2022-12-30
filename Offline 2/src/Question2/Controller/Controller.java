package Question2.Controller;

import Question2.Student.MyStudent;
import Question2.Teacher.MyTeacher;

import java.util.List;
import java.util.Map;

public interface Controller extends Runnable{
     void registerStudent(MyStudent s);
     void registerTeacher(MyTeacher t);
     void requestAnswerScriptsAndResult();
     void sendForScrutinizing();
     void publishResult();
     void sendForReExamine(int i);
     void activator();
     void replyAfterReExamine(int x);
     void askForReExamine();
     void setIndex(int x);
     void setUpdate();
     void setMarkSheet(List<Map<String, Integer>> markSheet);

}
