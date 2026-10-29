public class ConfFile {
    private String PathArchivoConfig;
    private static ConfFile configuracion;

    public static void initialize(String PathArchivoConfig){
        if (configuracion != null){
           throw new IllegalStateException("Already Created");
        }
        synchronized(ConfFile.class){
            if (configuracion == null){
                configuracion = new ConfFile(PathArchivoConfig);
            } else {
                throw new IllegalStateException("Already Created");
            }
        }
    }

    private ConfFile(String PathArchivoConfig){
        this.PathArchivoConfig = PathArchivoConfig;
    }

    public static String getConf(){
        return configuracion.PathArchivoConfig;
    }

    public static void setConf(String Path){
        configuracion.PathArchivoConfig = Path;
    }
}
