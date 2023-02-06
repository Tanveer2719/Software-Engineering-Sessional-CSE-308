package Question2;

public abstract class Coffee {
    protected int price;

    public Coffee(){
        price = 100;
    }

    public abstract void prepareCoffee();
    public abstract int getPrice();
    public void setPrice(int price){
        this.price = price;
    }

}
