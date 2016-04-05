package closure;

/**
 * Created by Иван on 05.04.2016.
 */
public class Caller {
    private Incrementable callBackReference;
    Caller(Incrementable incrementable){
        callBackReference = incrementable;
    }
    void go(){
        callBackReference.increment();
    }
}
