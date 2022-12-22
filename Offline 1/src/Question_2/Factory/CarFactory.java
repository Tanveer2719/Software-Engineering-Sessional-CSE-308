package Question_2.Factory;

import Question_2.Models.BMW;
import Question_2.Models.Car;
import Question_2.Models.Tesla;
import Question_2.Models.Toyota;

public class CarFactory {

    Car car = null;

    public Car getCar(String continent){
        if(continent.toLowerCase().equals("asia")){
            car = new Toyota();
        }
        else if(continent.toLowerCase().equals("europe")){
            car =  new BMW();
        }
        else if(continent.toLowerCase().equals("north america")){
            car =  new Tesla();
        }

        return car;
    }





}
