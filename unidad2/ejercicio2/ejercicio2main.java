public class ejercicio2main {
    public static void main(String[] args){
        databaseCon database1 = databaseCon.getInstance();
        String query = "CREATE TABLE tienda(nombre varchar(255), direccion varchar(255))";
        database1.createQuery(query);
        query = "INSERT INTO tienda VALUES('drugstore', 'Avenida de prueba')";
        database1.updateQuery(query);
        query = "INSERT INTO tienda VALUES('farmacia', 'Calle principal')";
        database1.updateQuery(query);
        query = "SELECT * FROM tienda";
        database1.selectQuery(query);
    }
}
