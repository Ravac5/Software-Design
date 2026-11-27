import java.util.List;

public class ejercicio5main {
    public static void main(String[] args){
        List<String> log;
        adminDispositivos driver1 = adminDispositivos.getInstance();
        adminDispositivos driver2 = adminDispositivos.getInstance();
        driver1.sendCommand("avanzar");
        driver1.cambiarEstado();
        driver1.sendCommand("avanzar");
        driver1.sendCommand("mover brazo");
        driver1.sendCommand("girar");
        driver1.sendCommand("cerrar ojos");
        log = driver2.getLog();
        System.out.println("Log de commandos enviados a driver 1, devueltos por driver 2");
        for (String l : log) {
            System.out.println(l);
        }
    }
}
