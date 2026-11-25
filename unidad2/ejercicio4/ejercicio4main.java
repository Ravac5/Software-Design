public class ejercicio4main {
    public static void main(String[] args){
        perfil user1 = new perfil("Marcelo", "Martinez", 23);
        perfil user2 = new perfil("Julieta", "Gomez", 23);
        perfil user3 = new perfil("Alvaro", "Lopez", 23);
        cache cache1 = cache.getInstance();

        cache1.almacenarPerfil("01", user1);
        cache1.almacenarPerfil("02", user3);

        System.out.println("Nombre del usuario con index 01: " + cache1.getPerfil("01").getNombre());
        cache1.actualizarPerfil("01", user2);
        System.out.println("Nombre del nuevo usuario con index 01: " + cache1.getPerfil("01").getNombre());
        System.out.println("Nombre del usuario con index 02: " + cache1.getPerfil("02").getNombre());
        cache1.eliminarPerfil("02");
        System.out.println("Usuario 02 eliminado!");
    }
}
