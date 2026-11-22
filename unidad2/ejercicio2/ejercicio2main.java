import java.util.Scanner;

public class ejercicio2main {
    public static void main(String[] args){
        databaseCon database1 = databaseCon.getInstance();
        Scanner input = new Scanner(System.in);
        String query;
        String parameter;
        while (true){
            System.out.println("1.Create table query\n2.Update table query\n3.Select table query\n4.Configure database\nWrite anything else to finish the program");
            query = input.nextLine();
            if (query.equals("1")){
                System.out.println("Write a create query");
                query = input.nextLine();
                database1.createQuery(query);
            } else if (query.equals("2")) {
                System.out.println("Write an update query");
                query = input.nextLine();
                database1.updateQuery(query);
            } else if (query.equals("3")){
                System.out.println("Write a select query");
                query = input.nextLine();
                database1.selectQuery(query);
            } else if (query.equals("4")){
                System.out.println("Database url (left blank for default: localhost:3306/database): ") ;
                parameter = input.nextLine();
                if (!parameter.isBlank()){
                    databaseCon.databaseUrl(parameter);
                }
                System.out.println("username: ");
                parameter = input.nextLine();
                databaseCon.selectUsername(parameter);
                System.out.println("password: ");
                parameter = input.nextLine();
                databaseCon.selectPassword(parameter);
            } else {
                System.out.println("Program finished!");
                break;
            }
        }

    }
}
