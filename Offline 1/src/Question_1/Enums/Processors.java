package Question_1.Enums;

public enum Processors {
    Rayzen("AMD Ryzen 7 5700X", 28000), Intel5("Intel Core i5",20000 ),
    Intel7("Intel Core i7",37000 ), Intel9("Intel Core i9", 65000);

    private String name;
    private int price;
    Processors(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
