package observerThread.imp;


import observerThread.MboObject;
import observerThread.Observable;
import observerThread.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public class Controller implements Observable {
    public Controller() {
        generateMap();
    }

    Map<MboObject, Boolean> mboMap = new HashMap<MboObject, Boolean>();

    private void generateMap() {
        List<MboObject> mboList = Reader.getMboList();
        for(MboObject mbo: mboList){
            mboMap.put(mbo, false);
        }
    }


    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println(controller.mboMap.get(new MboObject("147229034", "76")));
    }

    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer) {
    //TODO запись параметра через next
        observer.update("");
    }
}
