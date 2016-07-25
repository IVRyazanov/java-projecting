package threading.lambda;

import java.io.*;

/**
 * Created by Ivan.Ryazanov on 27.06.2016.
 */
public class Test implements Externalizable {
    public int i = 5;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Integer i = new Integer(127);
        Integer y = 127;
        String a = "Костя";
        String b = "Костя";
        System.out.println(a==b);
        //System.out.println(i==y);
        Test test = new Test();
        ObjectOutputStream outputStreamWriter = new ObjectOutputStream(new FileOutputStream(new File("1")));
        outputStreamWriter.writeObject(test);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("1")));
        Test test1 = (Test) objectInputStream.readObject();
        System.out.println(test1.i);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        i = (Integer)in.readObject();
    }
}
