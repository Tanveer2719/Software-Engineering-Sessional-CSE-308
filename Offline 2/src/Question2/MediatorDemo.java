package Question2;

import Question2.Controller.ConcreteController;
import Question2.Controller.Controller;
import Question2.Student.MyStudent;
import Question2.Student.NewStudent;
import Question2.Teacher.MyTeacher;
import Question2.Teacher.NewTeacher;

public class MediatorDemo {
    public static void main(String[] args) {
        Controller controller = new ConcreteController();


        MyTeacher t1 = new NewTeacher(controller, "Hasan Bhuiyan" , "Chemistry");
        MyTeacher t2 = new NewTeacher(controller, "Abu Hasib" , "Bangla");

        MyStudent s1 = new NewStudent(controller, "Kalam" , "1");
        MyStudent s2 = new NewStudent(controller, "Hasan", "2");
        MyStudent s3 = new NewStudent(controller, "Abir" , "3");
        MyStudent s4 = new NewStudent(controller, "Babu", "4");


        controller.registerStudent(s1);
        controller.registerStudent(s2);
        controller.registerStudent(s3);
        controller.registerStudent(s4);

        controller.registerTeacher(t1);
        controller.registerTeacher(t2);

        new Thread(controller).start();



    }
}
