import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseCon {
    private static final String url = "jdbc:mysql://localhost:3306/database";
    private static final String username = "test";
    private static final String password = "test";
    private static databaseCon instance;

    public static databaseCon getInstance(){
        if (instance == null){
            instance = new databaseCon();
        }
        return instance;
    }

    private databaseCon(){}

    public void createQuery(String sqlQuery){
        try (Connection connection = DriverManager.getConnection(url, username, password); Statement stmt = connection.createStatement()) {
            stmt.execute(sqlQuery);
            System.out.println("Table created succesfully!");

            } catch (SQLException e){
            throw new IllegalStateException("No se pudo realizar la consulta!" ,e);
        }
    }

    public void updateQuery(String sqlQuery){
        try (Connection connection = DriverManager.getConnection(url, username, password); Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sqlQuery);
            System.out.println("updated succesfully!");

        } catch (SQLException e){
            throw new IllegalStateException("No se pudo realizar la consulta!" ,e);
        }
    }

    public void selectQuery(String sqlQuery){
        try (Connection connection = DriverManager.getConnection(url, username, password); Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);
            ResultSetMetaData metaData = rs.getMetaData();

            System.out.println("------------------------");
            System.out.println("TABLE");
            System.out.println("------------------------");

            while(rs.next()){
                for (int column = 1; column <= metaData.getColumnCount(); column++){
                    System.out.println(metaData.getColumnName(column) + ": " + rs.getObject(column));
                }
                System.out.println("---------------------------------");
            }

        } catch (SQLException e){
            throw new IllegalStateException("No se pudo realizar la consulta!" ,e);
        }
    }
}
