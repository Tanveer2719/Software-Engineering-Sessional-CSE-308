package Abstract_Factory.BatBAll.Factory;

import Abstract_Factory.BatBAll.Ball.CricketBall;
import Abstract_Factory.BatBAll.Bat.CricketBat;

public class CricketFactory implements SportsFactory {

    CricketBat bat = new CricketBat() ;
    CricketBall ball = new CricketBall() ;


    private void getBat() {
        bat.color("Yellow");
        bat.price(2000);
    }

    private void getBall(){
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
