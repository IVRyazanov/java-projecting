package threading.philosopher;

/**
 * Created by Иван on 06.06.2016.
 */
public class Flatware {
    protected volatile boolean isUse = false;

    public synchronized boolean isUse() {
        return isUse;
    }

    public synchronized void setUse(boolean use) {
        isUse = use;
    }
}
