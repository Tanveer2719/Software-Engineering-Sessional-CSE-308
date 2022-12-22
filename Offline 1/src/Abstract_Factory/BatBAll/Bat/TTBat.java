package Abstract_Factory.BatBAll.Bat;


public class TTBat implements Bat {
    private String color;
    private int price;

    @Override
    public void color(String color) {
        // System.out.println("The color of the bat is" + color);
        this.color = color;

    }

    @Override
    public void price(int price) {
        // System.out.println("Price is " + price + " BDT");
        this.price = price;

    }

    @Override
    public void print() {
        System.out.println("The color of the bat is : " + color);
        System.out.println("The price of the bat is : " + price);
    }
}
