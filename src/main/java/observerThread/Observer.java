package observerThread;

import java.util.List;

/**
 * Created by Ivan.Ryazanov on 11.04.2016.
 */
public interface Observer {
    void update(List<MboObject> listMbos);
}
