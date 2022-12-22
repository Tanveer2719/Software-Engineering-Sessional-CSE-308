package Question_1.Enums;

public enum GraphicsCard {
    GC1(2,6500), GC2(4,7600);

    int size, price;
    private GraphicsCard(int size, int price){
        this.size = size;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
