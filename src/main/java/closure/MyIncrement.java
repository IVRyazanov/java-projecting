package closure;

/**
 * Created by Иван on 05.04.2016.
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Другая операция");
    }
    public static void f(MyIncrement myIncrement){
        myIncrement.increment();
    }
}
