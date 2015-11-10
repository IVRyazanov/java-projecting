package factory;

import factory.product.PlanWOPartition;
import factory.product.VneplanWOPartition;

/**
 * Created by Иван on 10.11.2015.
 */
public class WOParitionCreator extends WOPartition {
    @Override
    public WORemote devide(String type) {
        WORemote newWoMbo = null;
        if(type.equalsIgnoreCase("Плановая")){
            newWoMbo = new PlanWOPartition();
        } else if(type.equalsIgnoreCase("Внеплановая")){
            newWoMbo = new VneplanWOPartition();
        }
        return newWoMbo;
    }
}
