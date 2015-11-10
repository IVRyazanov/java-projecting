package WOPartition;

import Mbo.*;

/**
 * Created by Иван on 11.11.2015.
 */
public class ESMDPart extends CreatorPartition {
    public ESMDPart(MboRemote parentWO) {
        super(parentWO);
    }



    @Override
    public MboRemote createPart() {
        System.out.println("ЕСМД создано");
        return new Mbo();
    }
}
