package Builder_Pattern;

import Builder_Pattern.Models.Builder;
import Builder_Pattern.Models.Car;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Director director = new Director();

        Builder fordCar = new Car("Ford");
        director.construct(fordCar);
        Product p1 = fordCar.getProduct();
        p1.show_product();
    }
}
