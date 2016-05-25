package threading;

import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 25.05.2016.
 */
public class CustomThread extends Thread {
    static volatile int counter = 0;
    private int countDown = 10;

    public CustomThread(int countDown){
        super(Integer.toString(counter++));
        this.countDown = countDown;
        start();
    }

    @Override
    public String toString() {
        return getName() + " " + countDown + "!";
    }

    public void run(){
        while (true){
            System.out.println(this);
            try {
                TimeUnit.SECONDS.sleep(1);
                if(--countDown == 0){
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new CustomThread(5);

        }
    }
}
