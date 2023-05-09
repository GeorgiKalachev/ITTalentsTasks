package Lutenica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DBManager {


    private static final DBManager instance = new DBManager();
    private Connection connection;
    private static final String IP = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "cadet";
    private static final String PASS = "cadet";
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

    public void addLutenicaBatch(int quantity, String babaName) throws SQLException {
        // Създаваме prepared statement за добавяне на запис в таблицата "lutenica"
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO lutenica (date, quantity, baba_name) VALUES (?, ?, ?)"
        );
        // Задаваме параметрите на prepared statement
        statement.setDate(1, new java.sql.Date(new Date().getTime())); // текущата дата
        statement.setInt(2, quantity); // количество на партидата
        statement.setString(3, babaName); // име на бабата, която е приготвила партидата
        // Изпълняваме заявката]
        statement.executeUpdate();
    }
}
