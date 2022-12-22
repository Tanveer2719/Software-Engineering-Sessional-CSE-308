package Question_1;

import Question_1.Models.*;

import java.util.Arrays;

import static Question_1.Enums.GraphicsCard.*;
import static Question_1.Enums.Ram.*;

public class Director {
    PCBuilder pcBuilder;

    public void construct(int choice){
        if(choice == 1){
            pcBuilder = new RayzenPC();
        }else if(choice == 2){
            pcBuilder = new Intel5PC();
        }else if(choice == 3){
            pcBuilder = new Intel7PC();
        }else if(choice == 4){
            pcBuilder = new Intel9PC();
        }
    }

    void addGraphicsCard(int index){
        if(index == 1){
            pcBuilder.addGraphicsCard(Arrays.asList(String.valueOf(GC1.getSize()), String.valueOf(GC1.getPrice())));
        }else if (index == 2){
            pcBuilder.addGraphicsCard(Arrays.asList(String.valueOf(GC2.getSize()), String.valueOf(GC2.getPrice())));
        }

    }

    void addRam(int index){
        if(index == 1) {
            pcBuilder.addRAM(Arrays.asList(String.valueOf(RAM1.getSize()), String.valueOf(RAM1.getFreq()), String.valueOf(RAM1.getPrice())));
        }
        else if(index == 2){
            pcBuilder.addRAM(Arrays.asList(String.valueOf(RAM2.getSize()), String.valueOf(RAM2.getFreq()), String.valueOf(RAM2.getPrice())));
        }
    }

    public void addExtra(int choice) {
        switch (choice){
            case 1:
            {
                addRam(1);  // '1' means 2666 hz ram
                break;
            }
            case 2:{
                addRam(2);     // '2' means 3200 hz ram
                break;
            }
            case 3:
            {
                addGraphicsCard(1);     // 2 gb
                break;
            }
            case 4:{
                addGraphicsCard(2);     // 4gb
                break;
            }
        }
    }

    public Product getProduct() {
        return pcBuilder.getPC();
    }
}
