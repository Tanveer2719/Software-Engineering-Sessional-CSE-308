package TemplatePattern;

public class Coffee extends CaffeineBeverage{
    @Override
    protected void addIngredients() {
        System.out.println("Milk and sugar is added to the cup");
    }

    @Override
    protected void brew() {
        System.out.println("Coffee is brewed in the hot water");

    }
}
