package TemplatePattern;

public class Tea extends CaffeineBeverage{
    @Override
    protected void brew () {
        System.out.println("Tea is Steeped in the boiling water");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Lemon is added to the tea");
    }
}
