package krasi;
public class DBManager {

    private static DBManager instance = new DBManager();
    private DBManager(){
        //initialize connection to DB
    }

    public static DBManager getInstance(){
        return instance;
    }

    public void saveCarWash(CarWash carWash){
        String sql = "INSERT INTO shop (name) VALUES (?)";
        /*
        PreparedStatement ps = con.prepare(sql);
        ps.setString(1, carWash.getName());
        ps.execute();
        //logic for gettin the generated id
        carWash.setid(generatedId);
         */

    }

    public void saveVehicleType(VehicleType vehicleType){
        String sql = "INSERT INTO vehicle_types (name) VALUES (?)";
    }

    public void saveService(Service service){
        String sql = "INSERT INTO services (name) VALUES (?)";
    }

    public void savePriceListItem(PriceListItem priceListItem){
        String sql = "INSERT INTO price_list (service_id, vehicle_type_id, price) VALUES (?, ?, ?)";
        //...

    }

    public void saveWorker(Worker worker){
        String sql = "INSERT INTO workers (name, age ,shop_id) VALUES (?, ?, ?)";
    }


    public void saveOrder(VehicleOrder vo) {
        String sql = "INSERT INTO vehicles (model, type_id, service_id, registered_at) VALUES (?, ?, ?, NOW())";
        vo.setId(3);
    }

    public double getPrice(Service service, VehicleType vehicleType) {
        String sql = "SELECT price FROM price_list WHERE service_id = ? AND vehicle_type_id = ?";
        return 3;
    }

    public void updateOrder(VehicleOrder vo, Worker worker) {
        String sql = "UPDATE vehicles SET serviced_at = NOW(), serviced_by = ? WHERE id = ?";
    }

    public int totalServicedFor24h() {
        String sql = "SELECT COUNT(*) FROM vehicles WHERE serviced_at IS NOT NULL AND serviced_at > (DATE_SUB(NOW(), INTERVAL 1 DAY))";
        return 30;
    }

    public int totalWorkersWith3OrMoreServiced() {
        String sql = """
                SELECT
                    serviced_by,
                    COUNT(*) AS total
                FROM vehicles 
                GROUP BY serviced_by
                HAVING COUNT(*) >= 3
                """;
        return 10;
    }

    public int mostWantedServiceFor24h() {
        String sql = """
                SELECT s.name, COUNT(v.id) AS total
                FROM services AS s
                JOIN vehicles AS v ON s.id = v.service_id AND v.serviced_at > (DATE_SUB(NOW(), INTERVAL 1 DAY))
                GROUP BY s.name
                ORDER BY total DESC LIMIT 1
                """;
        return 1;
    }

    public int mostCommonVType() {
        String sql = """
                SELECT 
                    vt.name, 
                    COUNT(v.id) AS total
                FROM vehicle_types AS vt
                JOIN vehicles AS v ON vt.id = v.vehicle_type_id
                GROUP BY vt.name
                ORDER BY total DESC LIMIT 1
                """;
        return 1;
    }

    public String youngestThatWorkedHardWithTrucks() {
        String sql = """
                SELECT 
                    w.name, 
                    COUNT(v.id) AS total
                FROM workers AS w
                JOIN vehicles AS v ON w.id = v.serviced_by
                JOIN vehicle_types AS vt ON v.vehicle_type_id = vt.id AND vt.name = 'TRUCK'
                GROUP BY w.name
                ORDER BY total DESC, w.age ASC LIMIT 1
                """;
        return "Iliya";
    }
}
