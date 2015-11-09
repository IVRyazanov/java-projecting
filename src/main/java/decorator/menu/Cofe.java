package decorator.menu;

import decorator.Beverage;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Cofe extends Beverage {
    public Cofe() {
        description = "Cofe";
    }

    @Override
    public double cost() {
        return 100;
    }
}
