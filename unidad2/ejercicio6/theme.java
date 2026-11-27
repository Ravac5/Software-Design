public class theme {

    private static volatile theme instance;
    public enum themes {Claro, Oscuro}
    private themes currentTheme = themes.Claro;
    private String colorFondo = "#FFFFFF";
    private String colorTexto = "#000000";

    private theme(){}

    public static theme getInstance(){
        if (instance != null){
            return instance;
        }
        synchronized(theme.class){
            if (instance == null) {
                instance = new theme();
            }
            return instance;
        }
    }

    public themes getTheme(){
        synchronized(this){
            return currentTheme;
        }
    }

    public String getColorFondo(){
        synchronized(this){
            return colorFondo;
        }
    }

    public String getColorTexto(){
        synchronized(this){
            return colorTexto;
        }
    }
    public void changeTheme(themes t){
        if (t == null){
            throw new IllegalArgumentException("null not accepted!");
        }
        synchronized(this){
            currentTheme = t;
            if (currentTheme == themes.Claro){
                colorTexto = "#000000";
                colorFondo = "#FFFFFF";
            } else {
                colorFondo = "#000000";
                colorTexto = "#FFFFFF";
            }
        }
    }
}
