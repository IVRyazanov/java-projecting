package decorator.additions;

import decorator.AdditionsDecorator;
import decorator.Beverage;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Lemon extends AdditionsDecorator {
    Beverage beverage;

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Lemon";
    }

    @Override
    public double cost() {
        return beverage.cost() + 5;
    }
}
