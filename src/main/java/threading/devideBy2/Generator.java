package threading.devideBy2;

import java.util.Random;

/**
 * Created by Иван on 29.05.2016.
 */
public class Generator {
    private static Random rand = new Random();
    public static int next(){
        return rand.nextInt();
    }
}
