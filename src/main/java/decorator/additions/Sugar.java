package decorator.additions;

import decorator.AdditionsDecorator;
import decorator.Beverage;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public class Sugar extends AdditionsDecorator {
    Beverage beverage;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 15;
    }
}
