package Question2.Controller;

import Question2.Student.MyStudent;
import Question2.Teacher.MyTeacher;

 public interface Controller extends Runnable{
     void registerStudent(MyStudent s);
     void registerTeacher(MyTeacher t);
     void requestAnswerScriptsAndResult();
     void sendForScrutinizing();
     void publishResult();
     void sendForReExamine(int i);
     void activator();
     void replyAfterReExamine(MyStudent x);
     void askForReExamine();
     void setIndex(int x);
     void updateMarks();

}
