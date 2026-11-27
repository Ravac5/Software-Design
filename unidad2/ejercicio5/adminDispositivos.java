import java.util.ArrayList;
import java.util.List;

public class adminDispositivos {

    private static volatile adminDispositivos instance;
    private static volatile boolean estado = false;
    private static volatile List<String> commandsLog = new ArrayList<>();
    private adminDispositivos(){}

    public static adminDispositivos getInstance(){
        if (instance != null){
            return instance;
        }
        synchronized(adminDispositivos.class){
            if (instance == null){
                instance = new adminDispositivos();
            }
            return instance;
        }
    }

    public void cambiarEstado(){
        synchronized(adminDispositivos.class){
            if (estado){
                estado = false;
                System.out.println("Desactivado!");
            } else {
                estado = true;
                System.out.println("Activado!");
            }
        }
    }

    public boolean getEstado(){
        synchronized(adminDispositivos.class){
            return estado;
        }
    }
    public boolean sendCommand(String command){
        synchronized(adminDispositivos.class){
            if (estado){
                commandsLog.add(command);
                System.out.println("Comando enviado!");
                return true;
            } else {
                System.out.println("Driver no activo!");
                return false;
            }
        }
    }
    public List<String> getLog(){
        synchronized(adminDispositivos.class){
            return commandsLog;
        }
    }
}
