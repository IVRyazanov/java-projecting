package factory;

/**
 * Created by Иван on 10.11.2015.
 */
public class Starter {
    public static void main(String[] args) {
        WOPartition woPartition = new WOParitionCreator();
        woPartition.devide("Плановая");
        woPartition.devide("Внеплановая");
    }
}
