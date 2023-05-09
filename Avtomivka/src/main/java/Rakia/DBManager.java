package Rakia;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

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

    public void savePerson(Person p) {
        try {
            String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, new Random().nextInt(210,1500));
            ps.setString(2, p.getName());
            ps.setString(3, p.getName() + "nqkoi si");
            ps.setString(4, p.getFactory().getClass().getSimpleName());
            ps.setString(5, p.getName());
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.setString(7,"AC_MGR");
            ps.setInt(8, new Random().nextInt(1000,8000));
            ps.setInt(9, 100);
            ps.setInt(10, 90);

            ps.executeUpdate();
            System.out.println("Employee " + p.getName() + " added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }

    }

    }
