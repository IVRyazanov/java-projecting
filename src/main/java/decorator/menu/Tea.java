package decorator.menu;

import decorator.Beverage;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Tea extends Beverage {
    public Tea() {
        description = "Tea";
    }

    @Override
    public double cost() {
        return 80;
    }
}
