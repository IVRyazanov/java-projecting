package spring.xmlUsage;

/**
 * Created by SBT-Ryazanov-IV on 05.09.2016.
 */
public class HelloWorld {
    private String message;
    static int counter;
    final private int id = counter++;

    @Override
    public String toString() {
        return "HelloWorld{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", counter=" + counter +
                '}';
    }
    public void init(){
        message = this.toString();
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }
}
