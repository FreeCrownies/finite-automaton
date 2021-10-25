public class Program {

    private static final Program INSTANCE = new Program();

    private Program() {
    }

    public void start() {
        loadSpeeches();
    }

    public static Program getInstance() {
        return INSTANCE;
    }

    private void loadSpeeches() {
        /* */
    }

}

