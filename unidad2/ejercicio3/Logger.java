import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private enum Levels { INFO, WARNING, ERROR }
    private static volatile Logger log;
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy::HH:mm:ss");

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
    private String getTime(){
        LocalDateTime time = LocalDateTime.now();
        return time.format(format);
    }

    private void logMessage(Levels level, String message){
        synchronized(Logger.class){
            System.out.println(getTime() + " [" + level + "]: " + message);
        }
    }

    public void errorMessage(String message){
        logMessage(Levels.ERROR, message);
    }

    public void infoMessage(String message){
        logMessage(Levels.INFO, message);
    }

    public void warningMessage(String message){
        logMessage(Levels.WARNING, message);
    }
}
