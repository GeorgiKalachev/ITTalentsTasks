package Avtomivka;

import Avtomivka.cars.Vehicles;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private static final DBManager instance = new DBManager();

    public static DBManager getInstance() {
        return instance;
    }

    public void saveCarWash(Avtomivka avtomivka) {
        //TODO
    }

    public void saveVehicleType(Vehicles vehType) {

        //TODO
    }


    public void savePRiceListItem(PriceListItem priceListItem) {
        //TODO
    }

    public void saveService(Service service) {
        //TODO
    }

    public void saveWorker(Worker worker) {

    }

    public void saveOrder(VehicleOrder vo) {

    }

    public void getPrice(Service service, Vehicles type) {

    }
}
