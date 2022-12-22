package Abstract_Factory.BatBAll.Factory;

import Abstract_Factory.BatBAll.Ball.TTBall;
import Abstract_Factory.BatBAll.Bat.TTBat;

public class TTFactory implements SportsFactory{
    TTBat bat = new TTBat();
    TTBall ball = new TTBall();


    public void getBat() {
        bat.color("Yellow");
        bat.price(2000);

    }

    public void getBall(){
        ball.color("White");
        ball.price(500);
    }

    @Override
    public void printPackage() {
        bat.print();
        ball.print();
    }

    @Override
    public void createPackage() {
        getBat();
        getBall();
    }
}
