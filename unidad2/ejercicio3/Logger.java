public class Logger {
    private List<String> levels = List.of("[INFO]","[WARNING]","[ERROR]")
    private static volatile Logger log;

    private Logger(){}

    public static Logger getInstance(){
        if (log != null){
            return log;
        }
        synchronized(Logger.class){
            if (log == null){
                log = new Logger();
            }
            return log;
        }
    }
}
