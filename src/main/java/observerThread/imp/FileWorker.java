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
    private static String pathToUpdate = null;
    private static String pathToError = null;
    private static FileWriter fileWriter;
    private static List<MboObject> mboList;

    public int getMboCount(){
        return mboList.size();
    }


    public FileWorker() throws Exception {
        fileWriter = openFile();
        mboList = readFile();
    }

    public static void setPathToUpdate(String pathToUpdate) {
        FileWorker.pathToUpdate = pathToUpdate;
    }

    public static void setPathToError(String pathToError) {
        FileWorker.pathToError = pathToError;
    }

    private static FileWriter openFile() throws Exception {
        if(pathToError == null)
            throw new Exception("Ошибка заполнения пути открытия файла прежде необходимо вызывать метод pathToError");
        try {
            fileWriter = new FileWriter(pathToError);
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



    public static List<MboObject> getMboList() {
        return mboList;
    }


    private static List<MboObject> readFile() throws Exception {
        if(pathToError == null)
            throw new Exception("Ошибка заполнения пути открытия файла прежде необходимо вызывать метод setPathToUpdate");
        List<MboObject> stringList = new ArrayList<MboObject>();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(pathToUpdate));
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
