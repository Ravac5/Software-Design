public class ejercicio1main{
    public static void main(String[] args){
        ConfFile.initialize(System.getProperty("user.home") + "/a.properties");
        System.out.println(ConfFile.getInstance().getValor("usuario"));
    }
}
