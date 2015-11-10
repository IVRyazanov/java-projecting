package WOPartition;

import Mbo.MboRemote;

/**
 * Created by Иван on 11.11.2015.
 */
public class CreatePPart extends CreatorPartition {
    public CreatePPart(MboRemote parentWO) {
        super(parentWO);
    }

    @Override
    public MboRemote createPart() {
        return (parentWO.getInt("h") == 820 ? new ESMDPart(parentWO) : parentWO.getInt("h") == 800 ? new StandartPart(parentWO) : null);
    }
}
