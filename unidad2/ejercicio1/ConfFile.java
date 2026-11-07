import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfFile {
    private static volatile ConfFile conf;
    private Properties prop = new Properties();

    public static synchronized ConfFile initialize(String path){
        if (conf == null) {
            conf = new ConfFile(path);
            return conf;
        }
        return conf;
    }

    private ConfFile(String path){
        try (FileInputStream archivo = new FileInputStream(path)) {
            prop.load(archivo);
        } catch (IOException e) {
            throw new IllegalStateException("no se pudo cargar la configuracion", e);
        }
    }

    public static ConfFile getInstance(){
        if (conf == null){
            throw new IllegalStateException("configuracion no inicializada");
        }
        return conf;
    }
    public String getValor(String clave) {
        return prop.getProperty(clave);
    }
}
