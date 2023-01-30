package TemplatePattern;

public abstract class CaffeineBeverage {
    public final void prepareBeverage(){
        boilWater();
        brew();
        pourInCup();
        addIngredients();
    }

    protected abstract void brew();
    protected abstract void addIngredients();

    void boilWater(){
        System.out.println("Water is boiled");
    }
    void pourInCup(){
        System.out.println("The mixture is poured in the cup");
    }


}
