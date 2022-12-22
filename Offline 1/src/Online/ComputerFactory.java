package Online;

import Online.Computer.CompA;
import Online.Computer.CompB;
import Online.Computer.CompC;
import Online.Computer.pc;

public class ComputerFactory {
    private pc  computer;

    void setPc(String s){
        if(s.equalsIgnoreCase("computerA")){
            computer = new CompA();
        }else if(s.equalsIgnoreCase("computerB")){
            computer = new CompB();
        }
        else if(s.equalsIgnoreCase("computerC")) {
            computer = new CompC();
        }
    }
    pc getPc(){
        return computer;
    }



}
