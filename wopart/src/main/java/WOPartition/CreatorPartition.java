package WOPartition;

import Mbo.MboRemote;
import WO.WO;

/**
 * Created by Иван on 11.11.2015.
 */
public abstract class CreatorPartition extends WO {
    MboRemote parentWO;

    public CreatorPartition(MboRemote parentWO) {
        this.parentWO = parentWO;
    }


    public abstract MboRemote createPart();
}
