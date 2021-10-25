import java.util.HashMap;

public class Console {

    static {
        registerTasks();
    }

    private static final HashMap<String, ConsoleTask> tasks = new HashMap<>();

    private static void registerTasks() {

    }

    private static void onReload() {

    }

    public interface ConsoleTask {

        void process(String[] args) throws Throwable;

    }
}
