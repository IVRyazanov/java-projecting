package observerThread.imp;

import observerThread.MboObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class FileWorker {
    private static String path = "src/main/resources/63-83.dsv";
    private static FileWriter fileWriter = openFile();

    private static FileWriter openFile() {
        try {
            fileWriter = new FileWriter("src/main/resources/not_completed.txt");
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            try {
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return fileWriter;
    }

    private static List<MboObject> mboList = readFile();


    public static List<MboObject> getMboList() {
        return mboList;
    }


    private static List<MboObject> readFile() {
        List<MboObject> stringList = new ArrayList<MboObject>();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = fileReader.readLine()) != null){
                MboObject mboObject = new MboObject(line.split(";")[0].replace("\"", ""), line.split(";")[1].replace("\"", ""));
                stringList.add(mboObject); // возвращает siteid
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {

                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return stringList;
    }

    public static void writeInFile(MboObject mboObject) throws IOException {
        String str = mboObject.toFileView();
        fileWriter.write(str);
    }

    public static void closeWriter() throws IOException {
        fileWriter.close();
    }





}
