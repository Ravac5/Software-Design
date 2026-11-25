public class ejercicio3main {
    public static void main(String[] args){
        Logger logger1 = Logger.getInstance();
        logger1.errorMessage("program failed!");
        logger1.warningMessage("variable x not defined, program still works!");
        logger1.infoMessage("class initialized!");
    }
}
