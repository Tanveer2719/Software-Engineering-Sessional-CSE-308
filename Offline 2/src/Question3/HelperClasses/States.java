package Question3.HelperClasses;

import Question3.Models.*;

public class States {
    public static State lessMoney = new LessMoney();
    public static State moreMoney = new GreaterMoney();
    public static State hasMoney = new HasMoney();
    public static State hasProduct = new HasProduct();
    public static State outOfProduct = new OutOfProduct();
    public static State sold = new Sold();
}
