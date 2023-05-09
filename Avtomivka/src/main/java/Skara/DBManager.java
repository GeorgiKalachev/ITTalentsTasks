package Skara;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final DBManager instance = new DBManager();
    private Connection connection;
    private static final String IP = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String DB_NAME = "hr";

    private DBManager() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME, USER, PASS);
            System.out.println("connection established");

        } catch (ClassNotFoundException e) {
            System.out.println("driver failed");
        } catch (SQLException e) {
            System.out.println("connection failed: " + e.getMessage());
        }
    }

    public static DBManager getInstance() {
        return instance;
    }


    

}
