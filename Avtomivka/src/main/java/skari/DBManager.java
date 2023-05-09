package skari;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DBManager {
    private static DBManager ourInstance = new DBManager();
    private Connection connection;
    private static final String IP = "192.168.7.50";
    private static final String PORT = "3306";
    private static final String USER = "cadet";
    private static final String PASS = "cadet";
    private static final String DB_NAME = "s12_test3";

    public static DBManager getInstance() {
        return ourInstance;
    }

    private DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+IP+":"+PORT+"/"+DB_NAME, USER, PASS);
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver failed");
        }
        catch (SQLException e){
            System.out.println("Connection failed");
        }
    }

    public void insertSales(Shop shop){

        String sql = "INSERT INTO SALES (shop_id, bread_type_id, meat_type_id, garnish_type_id, date_created) VALUES (?,?,?,?,?)";
        try {
            File f = new File(LocalDate.now().toString()+".txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()){
                try{
                    String sale = sc.nextLine();
                    String[] saleParts = sale.split(",");
                    String bread = saleParts[0];
                    String meat = saleParts[1];
                    String salad = saleParts[2];
                    String date = saleParts[4];
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, shop.getId());
                    ps.setInt(2, getBreadId(bread));
                    ps.setInt(3, getMeatId(meat));
                    ps.setInt(4, getSaladId(salad));
                    ps.setDate(5, java.sql.Date.valueOf(date));
                    ps.executeUpdate();
                }
                catch (SQLException e){
                    System.out.println("Sale import failed.");
                }
            }

        } catch (IOException e) {
            System.out.println("draznish me");
        }
    }

    private int getMeatId(String meatName) throws SQLException {
        String sql = "SELECT id FROM meat_types WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, meatName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    private int getBreadId(String breadName) throws SQLException {
        String sql = "SELECT id FROM bread_types WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, breadName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    private int getSaladId(String saladName) throws SQLException {
        String sql = "SELECT id FROM garnish_types WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, saladName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    public Connection getConnection() {
        return connection;
    }
}
