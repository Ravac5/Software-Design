import java.util.HashMap;
import java.util.Map;

public class cache {

    private static volatile cache instance;
    private final Map<String, perfil> perfilUsuarios; // index, perfil
    private cache(){
        perfilUsuarios = new HashMap<>();
    }

    public static cache getInstance(){

        if (instance != null){
            return instance;
        }
        synchronized(cache.class){
            if (instance == null){
                instance = new cache();
            }
        }
        return instance;
    }

    public void almacenarPerfil(String index, perfil usuario){
        synchronized(cache.class){
            if (usuario == null || index == null){
                throw new NullPointerException();
            }
            if (!perfilUsuarios.containsKey(index)){
                perfilUsuarios.put(index, usuario);
            } else {
                throw new IllegalStateException("Perfil con index " + index + " ya existe!");
            }
        }
    }
    public void actualizarPerfil(String index, perfil usuario){
        synchronized(cache.class){
            if (usuario == null || index == null){
                throw new NullPointerException();
            }
            if (!perfilUsuarios.containsKey(index)){
                throw new IllegalStateException("No existe el perfil!");
            }
            perfilUsuarios.replace(index, usuario);
        }
    }

    public void eliminarPerfil(String index){
        synchronized(cache.class){
            perfilUsuarios.remove(index);
        }
    }

    public perfil getPerfil(String index){
        synchronized(cache.class){
            return perfilUsuarios.get(index);
        }
    }
}
