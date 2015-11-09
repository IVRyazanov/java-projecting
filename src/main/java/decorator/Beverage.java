package decorator;

/**
 * Created by Ivan.Ryazanov on 09.11.2015.
 */
public abstract class Beverage {
    protected String description = "Unknown description";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
