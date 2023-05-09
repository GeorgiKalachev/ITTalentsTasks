package GasStation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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

    public void getColumnsAndGasLoadedOnEach() {

        try {
            String sql = "SELECT kolonka_id c," +
                    "      fuel_type g," +
                    "      fuel_quantity g," +
                    "      loading_time " +
                    "      FROM station_loadings";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.execute();

        }catch (SQLException e){
            System.out.println("ok");
        }

    }

    public void totalWorkersWith3OrMoreServiced() {

        try {
            String sql = "SELECT kolonka_id c," +
                    "      fuel_type g," +
                    "      fuel_quantity g," +
                    "      loading_time " +
                    "      FROM station_loadings";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.execute();

        }catch (SQLException e){
            System.out.println("ok");
        }

    }

    public void saveOrder(String name, String gas, int litresToLoad, LocalDate now) {
        String sql = "INSERT INTO station_loadings (kolonka_id, fuel_type, fuel_quan) VALUES (?, ?, ?, NOW())";

        //“station_loadings” и да съдържа следните колони:
        //- kolonka_id - номера на колонката за зареждане
        //- fuel_type - тип гориво - бензин, дизел или газ
        //- fuel_quantity - заредено количество в литри
        //- loading_time - време на зареждане.
    }
}
