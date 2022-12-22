package Abstract_Factory.BatBAll.Demo;

import Abstract_Factory.BatBAll.Factory.CricketFactory;
import Abstract_Factory.BatBAll.Factory.SportsFactory;
import Abstract_Factory.BatBAll.Factory.TTFactory;

public class AbstractFactoryExample {
    public static void main(String[] args) {

        System.out.println("********** Cricket ********");
        SportsFactory cricketFactory = new CricketFactory();
        cricketFactory.createPackage();
        cricketFactory.printPackage();

        System.out.println("********** TT ********");
        SportsFactory ttFactory = new TTFactory();
        ttFactory.createPackage();
        ttFactory.printPackage();

    }
}
