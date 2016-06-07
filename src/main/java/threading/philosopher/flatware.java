package threading.philosopher;

/**
 * Created by Иван on 06.06.2016.
 */
public class Flatware {
    private static int count = 1;
    protected int id = count++;

    @Override
    public String toString() {
        return "Flatware{" +
                "id=" + id +
                ", isUse=" + isUse +
                '}';
    }

    protected volatile boolean isUse = false;

    public  boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public synchronized void take() throws InterruptedException {
        if(isUse()){
            wait();
        }
        setUse(true);
    }

    public synchronized void drop() throws InterruptedException {
        setUse(false);
        notifyAll();
    }
}
