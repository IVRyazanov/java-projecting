import classLoader.Module;

/**
 * Created by Ivan.Ryazanov on 05.05.2016.
 */
public class ModulePrinter implements Module {

    @Override
    public void load() {
        System.out.println("Module " + this.getClass() + " loading ...");
    }

    @Override
    public int run() {
        System.out.println("Module " + this.getClass() + " running ...");
        return EXIT_SUCCESS;
    }

    @Override
    public void unload() {
        System.out.println("Module " + this.getClass() + " inloading ...");
    }
}
