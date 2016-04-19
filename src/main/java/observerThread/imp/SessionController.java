package observerThread.imp;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ivan.Ryazanov on 19.04.2016.
 */
public  class SessionController implements Iterable{
    private static Map<String, String> uiMap = getUIMap();
    private Iterator<Map.Entry<String, String>> iterator = uiMap.entrySet().iterator();

    public Iterator<Map.Entry<String, String>> getIterator() {
        return iterator;
    }

    public int getUiCount(){
        return uiMap.size();
    }

    private static Map<String, String> getUIMap(){
        Map<String, String> uiMap = new TreeMap<String, String>();
        uiMap.put("MAXIMOUI001", "10.22.64.58");
        uiMap.put("MAXIMOUI002", "10.22.64.58");
        uiMap.put("MAXIMOUI003", "10.22.64.58");
        uiMap.put("MAXIMOUI004", "10.22.64.58");
        uiMap.put("MAXIMOUI005", "10.22.64.58");
        uiMap.put("MAXIMOUI006", "10.22.64.58");
        uiMap.put("MAXIMOUI007", "10.22.64.58");
        uiMap.put("MAXIMOUI008", "10.22.64.58");
        uiMap.put("MAXIMOUI009", "10.22.64.58");
        uiMap.put("MAXIMOUI010", "10.22.64.58");
        uiMap.put("MAXIMOUI011", "10.22.64.89");
        uiMap.put("MAXIMOUI012", "10.22.64.89");
        uiMap.put("MAXIMOUI013", "10.22.64.89");
        uiMap.put("MAXIMOUI014", "10.22.64.89");
        uiMap.put("MAXIMOUI015", "10.22.64.89");
        uiMap.put("MAXIMOUI016", "10.22.64.89");
        uiMap.put("MAXIMOUI017", "10.22.64.89");
        uiMap.put("MAXIMOUI018", "10.22.64.89");
        uiMap.put("MAXIMOUI019", "10.22.64.89");
        uiMap.put("MAXIMOUI020", "10.22.64.89");
        uiMap.put("MAXIMOUI021", "10.22.64.65");
        uiMap.put("MAXIMOUI022", "10.22.64.65");
        uiMap.put("MAXIMOUI023", "10.22.64.65");
        uiMap.put("MAXIMOUI024", "10.22.64.65");
        uiMap.put("MAXIMOUI025", "10.22.64.65");
        uiMap.put("MAXIMOUI026", "10.22.64.65");
        uiMap.put("MAXIMOUI027", "10.22.64.65");
        uiMap.put("MAXIMOUI028", "10.22.64.65");
        uiMap.put("MAXIMOUI029", "10.22.64.65");
        uiMap.put("MAXIMOUI030", "10.22.64.65");
        uiMap.put("MAXIMOUI031", "10.22.64.65");
        uiMap.put("MAXIMOUI032", "10.22.64.65");
        uiMap.put("MAXIMOUI033", "10.22.64.65");
        uiMap.put("MAXIMOUI034", "10.22.64.65");
        uiMap.put("MAXIMOUI035", "10.22.64.65");
        uiMap.put("MAXIMOUI036", "10.22.64.65");
        uiMap.put("MAXIMOUI037", "10.22.64.65");
        uiMap.put("MAXIMOUI038", "10.22.64.65");
        uiMap.put("MAXIMOUI039", "10.22.64.65");
        uiMap.put("MAXIMOUI040", "10.22.64.65");
        uiMap.put("MAXIMOUI041", "10.22.64.65");
        uiMap.put("MAXIMOUI042", "10.22.64.65");
        uiMap.put("MAXIMOUI043", "10.22.64.65");
        uiMap.put("MAXIMOUI044", "10.22.64.65");
        uiMap.put("MAXIMOUI045", "10.22.64.65");
        uiMap.put("MAXIMOUI046", "10.22.64.65");
        uiMap.put("MAXIMOUI047", "10.22.64.65");
        uiMap.put("MAXIMOUI048", "10.22.64.65");
        uiMap.put("MAXIMOUI049", "10.22.64.65");
        uiMap.put("MAXIMOUI050", "10.22.64.65");
        uiMap.put("MAXIMOUI051", "10.22.64.90");
        uiMap.put("MAXIMOUI052", "10.22.64.90");
        uiMap.put("MAXIMOUI053", "10.22.64.90");
        uiMap.put("MAXIMOUI054", "10.22.64.90");
        uiMap.put("MAXIMOUI055", "10.22.64.90");
        uiMap.put("MAXIMOUI056", "10.22.64.90");
        uiMap.put("MAXIMOUI057", "10.22.64.90");
        uiMap.put("MAXIMOUI058", "10.22.64.90");
        uiMap.put("MAXIMOUI059", "10.22.64.90");
        uiMap.put("MAXIMOUI060", "10.22.64.90");
        uiMap.put("MAXIMOUI061", "10.22.64.90");
        uiMap.put("MAXIMOUI062", "10.22.64.90");
        uiMap.put("MAXIMOUI063", "10.22.64.90");
        uiMap.put("MAXIMOUI064", "10.22.64.90");
        uiMap.put("MAXIMOUI065", "10.22.64.90");
        uiMap.put("MAXIMOUI066", "10.22.64.90");
        uiMap.put("MAXIMOUI067", "10.22.64.90");
        uiMap.put("MAXIMOUI068", "10.22.64.90");
        uiMap.put("MAXIMOUI069", "10.22.64.90");
        uiMap.put("MAXIMOUI070", "10.22.64.90");
        uiMap.put("MAXIMOUI071", "10.22.64.89");
        uiMap.put("MAXIMOUI072", "10.22.64.89");
        uiMap.put("MAXIMOUI073", "10.22.64.89");
        uiMap.put("MAXIMOUI074", "10.22.64.89");
        uiMap.put("MAXIMOUI075", "10.22.64.89");
        uiMap.put("MAXIMOUI076", "10.22.64.89");
        uiMap.put("MAXIMOUI077", "10.22.64.89");
        uiMap.put("MAXIMOUI079", "10.22.64.89");
        uiMap.put("MAXIMOUI080", "10.22.64.89");
        uiMap.put("MAXIMOUI081", "10.22.64.89");
        uiMap.put("MAXIMOUI082", "10.22.64.89");
        uiMap.put("MAXIMOUI083", "10.22.64.89");
        uiMap.put("MAXIMOUI084", "10.22.64.89");
        uiMap.put("MAXIMOUI085", "10.22.64.89");
        uiMap.put("MAXIMOUI086", "10.22.64.89");
        uiMap.put("MAXIMOUI087", "10.22.64.89");
        uiMap.put("MAXIMOUI088", "10.22.64.89");
        uiMap.put("MAXIMOUI089", "10.22.64.89");
        uiMap.put("MAXIMOUI090", "10.22.64.89");
        uiMap.put("MAXIMOUI091", "10.22.64.89");
        uiMap.put("MAXIMOUI092", "10.22.64.89");
        uiMap.put("MAXIMOUI093", "10.22.64.89");
        uiMap.put("MAXIMOUI094", "10.22.64.89");
        uiMap.put("MAXIMOUI095", "10.22.64.89");
        uiMap.put("MAXIMOUI096", "10.22.64.89");
        uiMap.put("MAXIMOUI097", "10.22.64.89");
        uiMap.put("MAXIMOUI098", "10.22.64.89");
        uiMap.put("MAXIMOUI099", "10.22.64.89");
        uiMap.put("MAXIMOUI100", "10.22.64.89");
        return uiMap;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            synchronized public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            synchronized public Map.Entry<String, String> next() {
                return iterator.next();
            }
        };
    }
}
