package WOPartition;

import Mbo.*;

/**
 * Created by Иван on 11.11.2015.
 */
public class StandartPart extends CreatorPartition {
    public StandartPart(MboRemote parentWO) {
        super(parentWO);
    }

    @Override
    public MboRemote createPart() {
        System.out.println("П создано");
        return new Mbo();
    }
}
