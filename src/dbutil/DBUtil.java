package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Employee";
    private static final String PASSWORD = "password";
    private static final String USER = "postgres";



    public static Connection getConnection(){


        Connection connection  = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;

    }

    public static void closeConnection(Connection connection){

        try {
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
