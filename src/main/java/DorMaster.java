import classLoader.Module;

/**
 * Created by Ivan.Ryazanov on 05.05.2016.
 */
public class DorMaster implements Module {
    @Override
    public void load() {
        System.out.println("ДОРМАСТЕР ГРУЗИТСЯ....");
    }

    @Override
    public int run() {
        System.out.println("ДОРМАСТЕР РАБОТАТЬ....");

        return 0;
    }

    @Override
    public void unload() {
        System.out.println("ДОРМАСТЕР УСТАЛ....");

    }
}
