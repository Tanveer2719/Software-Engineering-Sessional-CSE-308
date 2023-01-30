package TemplatePattern;

public class Demo {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();
        System.out.println("\n***** coffee preparation *****");
        coffee.prepareBeverage();
        System.out.println("\n***** tea preparation *****");
        tea.prepareBeverage();
    }
}
