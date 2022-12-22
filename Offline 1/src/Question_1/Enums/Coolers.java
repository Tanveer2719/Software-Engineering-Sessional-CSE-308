package Question_1.Enums;

public enum Coolers {
    airCooler(36000), liqCooler(17000);

    private int price;
    Coolers(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
