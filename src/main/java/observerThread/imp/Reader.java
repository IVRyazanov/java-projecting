package observerThread.imp;

import observerThread.MboObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Reader {
    private static String path = "src/main/resources/63-83.dsv";

    private static List<MboObject> mboList = readFile();


    public static List<MboObject> getMboList() {
        return mboList;
    }


    private static List<MboObject> readFile() {
        List<MboObject> stringList = new ArrayList<MboObject>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = fileReader.readLine()) != null){
                MboObject mboObject = new MboObject(line.split(";")[0].replace("\"", ""), line.split(";")[1].replace("\"", ""));
                stringList.add(mboObject); // возвращает siteid
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return stringList;
    }

}
