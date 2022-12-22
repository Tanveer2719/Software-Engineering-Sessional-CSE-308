package Question_1.Enums;

public enum DVD {
    dvd1(6000);

    private int price;
    DVD(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
