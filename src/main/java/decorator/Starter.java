package decorator;

import decorator.additions.Lemon;
import decorator.additions.Sugar;
import decorator.menu.Cofe;
import decorator.menu.Tea;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Starter {
    public static void main(String[] args) {
        Beverage beverage = new Cofe();
        beverage = new Sugar(beverage);
        System.out.println("Cost of "+ beverage.getDescription() + " = " +  beverage.cost());
        Beverage beverage1 = new Tea();
        beverage1 = new Sugar(beverage1);
        beverage1 = new Lemon(beverage1);
        System.out.println("Cost of "+ beverage1.getDescription() + " = " +  beverage1.cost());
    }
}
