package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static String url = "jdbc:postgresql://localhost:5432/jdbc-java";
    private static String password = "asbiredebob123";
    private static String user = "postgres";
    private static Connection connection = null;

    static {
        connect();
    }

    public SingleConnection(){
        connect();
    }

    private static void connect(){
        try{

            if(connection != null){
                return;
            }

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            System.out.println("Database connected successfully. " + connection);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
