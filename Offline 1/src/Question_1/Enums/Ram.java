package Question_1.Enums;

public enum Ram {
    RAM1(8,2666,2620), RAM2(8,3200,2950);

    private int price;
    private int freq;
    private int size;

    Ram(int size, int freq, int  price){
        this.freq = freq;
        this.size = size;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public int getFreq() {
        return freq;
    }
    public int getSize() {
        return size;
    }
}
