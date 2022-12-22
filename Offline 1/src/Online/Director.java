package Online;

import Online.Computer.pc;

import java.util.List;

public class Director {
    private ComputerFactory computerFactory = new ComputerFactory();
    private ShapeFactory shapeFactory = new ShapeFactory();

    void getData(String cname, String sname, List<int> param){
        computerFactory.setPc(cname);
        if(sname.equalsIgnoreCase("Circle")){

        }

    }
}
