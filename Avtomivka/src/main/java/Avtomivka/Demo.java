package Avtomivka;

import Avtomivka.cars.Jeep;
import Avtomivka.cars.NormalCar;
import Avtomivka.cars.Truck;
import Avtomivka.cars.Vehicles;

import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {



        Avtomivka avtomivka = new Avtomivka();
        DBManager.getInstance().saveCarWash(avtomivka);

        Worker.avtomivka = avtomivka;
        List<Vehicles> vehiclesList = List.of(
                new NormalCar("Car"),
                new Jeep("Jeep"),
                new Truck("Truck")
        );
        for (Vehicles vt : vehiclesList) {
            DBManager.getInstance().saveVehicleType(vt);
        }

        List<Service> serviceList = List.of(
                new Service("Inner Wash"),
                new Service("Outer Wash"),
                new Service("Combined Wash")
        );
        for (Service s : serviceList) {
            DBManager.getInstance().saveService(s);
        }

        for (Service s : serviceList) {
            for (Vehicles vt : vehiclesList) {
                PriceListItem plt = new PriceListItem(s,vt,new Random().nextDouble(20,40));
                DBManager.getInstance().savePRiceListItem(plt);
                avtomivka.addPriceListItem(plt);
            }
        }
        for (int i = 1;i <= 5; i++){
            Worker worker = new Worker("Worker " + (i),i + 20);
            avtomivka.hireWorker(worker);
            DBManager.getInstance().saveWorker(worker);
        }


        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            Service ranservice = serviceList.get(r.nextInt(serviceList.size()));
            Vehicles random = vehiclesList.get(r.nextInt(vehiclesList.size()));
            VehicleOrder vo = new VehicleOrder("Random model",random,ranservice);
            avtomivka.recieveOrder(vo);
        }

    }


}
