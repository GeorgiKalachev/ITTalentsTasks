import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class DBManager {
    private static final DBManager instance = new DBManager();
    private static Connection connection;
    private static final String IP = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String DB_NAME = "s15_test3_carshop";

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

    public static void saveDiagnostic(Diagnostic diagnostic) {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO diagnosticians (name, age) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, diagnostic.getName());
            ps.setInt(1, diagnostic.getAge());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            diagnostic.setId(keys.getInt(1));
        } catch (SQLException e) {
            System.out.println("Error adding diagnostic " + e.getMessage());
        }
    }

    public static void saveWorker(Worker worker) {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO workers (name, age) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, worker.getName());
            ps.setInt(1, worker.getAge());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            worker.setId(keys.getInt(1));
        } catch (SQLException e) {
            System.out.println("Error adding diagnostic " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void saveOrder(Order order) {
    }


    public int saveCar(Car car) {

        try {
            Connection c = getConnection();

            // if car exists
            PreparedStatement checkCarStmt = c.prepareStatement("SELECT * FROM cars WHERE license_plate = ?");
            checkCarStmt.setString(1, car.getRegNumber());
            ResultSet carResult = checkCarStmt.executeQuery();

            if (!carResult.next()) {
                // it doesnt
                PreparedStatement addCarStmt = c.prepareStatement("INSERT INTO cars (license_plate, phone_number) VALUES (?, ?)");
                addCarStmt.setString(1, car.getRegNumber());
                addCarStmt.setString(2, car.getTelNumber());
                addCarStmt.executeUpdate();


                PreparedStatement getCarIdStmt = c.prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet carIdResult = getCarIdStmt.executeQuery();
                carIdResult.next();
                int carId = carIdResult.getInt(1);
                car.setId(carId);
                return carId;
            }else {
                return carResult.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("fack");
        }
    }

    public void stats2() {
        //брой поръчки, които са за услуги тип РЕМОНТ и брой поръчки, които са за услуги тип
        //ПОДДРЪЖКА
        try {

            String sql = "SELECT service_type, COUNT(*) as count " +
                    "FROM orders o" +
                    "JOIN services s"
                    "ON  o.service_id = s.service_id" +
                    "WHERE service_type = 'REMONT' AND service_type = 'PODRYJKA " +
                    "GROUP BY service_type";
            Connection c = DBManager.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, 9);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getString("meat_name"));
        }catch (SQLException e){
            System.out.println("fack");
        }
    }

    public void stat1() {
        try {
            //брой поръчки, които са заявени (регистрирани) за последните 30 дни (5т)
            String sql = "SELECT COUNT(*) AS total FROM orders WHERE closed_at = ?";//9
            Connection c = DBManager.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            LocalDateTime datetime = LocalDateTime.now();
            ps.setObject(1, datetime);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getInt("total"));
        }catch (SQLException e){
            System.out.println("fack");
        }
    }
}
