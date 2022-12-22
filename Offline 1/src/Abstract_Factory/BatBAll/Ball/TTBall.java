package Abstract_Factory.BatBAll.Ball;


import Abstract_Factory.BatBAll.Ball.Ball;

public class TTBall implements Ball {
    private String color;
    private int price;

    @Override
    public void color(String color) {
       // System.out.println("The color of the ball is" + color);
        this.color = color;
    }

    @Override
    public void price(int price){
        //System.out.println("Price is " + price + " BDT");
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println("The color of the ball is : " + color);
        System.out.println("The price of the ball is : " + price);
    }


}
