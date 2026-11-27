public class ejercicio6main {
    public static void main(String[] args){
        theme tema1 = theme.getInstance();
        theme tema2 = theme.getInstance();
        System.out.println("tema actual objeto tema1: " + tema1.getTheme());
        System.out.println("Color de fondo(hex): " + tema1.getColorFondo());
        System.out.println("Color de texto(hex): " + tema1.getColorTexto());
        tema1.changeTheme(theme.themes.Oscuro);
        System.out.println("tema oscuro aplicado!");
        System.out.println("tema actual objeto tema2: " + tema2.getTheme());
        System.out.println("Color de fondo(hex): " + tema2.getColorFondo());
        System.out.println("Color de texto(hex): " + tema2.getColorTexto());
    }
}
