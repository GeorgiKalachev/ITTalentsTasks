package avtomivka;

import java.util.List;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {

        CarWash carWash = new CarWash("Krasi`s car wash");
        DBManager.getInstance().saveCarWash(carWash);
        Worker.carWash = carWash;

        List<VehicleType> vehicleTypes = List.of(
                new VehicleType(VehicleType.VehicleTypeName.CAR),
                new VehicleType(VehicleType.VehicleTypeName.JEEP),
                new VehicleType(VehicleType.VehicleTypeName.TRUCK));
        for(VehicleType vt : vehicleTypes){
            DBManager.getInstance().saveVehicleType(vt);
        }

        List<Service> services = List.of(
                new Service(Service.ServiceName.INNER),
                new Service(Service.ServiceName.OUTER),
                new Service(Service.ServiceName.COMBINED)
        );

        for(Service s : services){
            DBManager.getInstance().saveService(s);
        }

        for(Service s : services){
            for (VehicleType vt : vehicleTypes){
                PriceListItem plt = new PriceListItem(s, vt, new Random().nextDouble(20, 30));
                carWash.addPriceListItem(plt);
                DBManager.getInstance().savePriceListItem(plt);
            }
        }

        WashTime washTime1 = new WashTime(Service.ServiceName.INNER, VehicleType.VehicleTypeName.CAR, 3000);
        WashTime washTime2 = new WashTime(Service.ServiceName.INNER, VehicleType.VehicleTypeName.JEEP, 5000);
        WashTime washTime3 = new WashTime(Service.ServiceName.INNER, VehicleType.VehicleTypeName.TRUCK, 8000);
        WashTime washTime4 = new WashTime(Service.ServiceName.OUTER, VehicleType.VehicleTypeName.CAR, 5000);
        WashTime washTime5 = new WashTime(Service.ServiceName.OUTER, VehicleType.VehicleTypeName.JEEP, 7000);
        WashTime washTime6 = new WashTime(Service.ServiceName.OUTER, VehicleType.VehicleTypeName.TRUCK, 10000);
        carWash.addWashTime(washTime1);
        carWash.addWashTime(washTime2);
        carWash.addWashTime(washTime3);
        carWash.addWashTime(washTime4);
        carWash.addWashTime(washTime5);
        carWash.addWashTime(washTime6);

        for (int i = 1; i <= 5; i++) {
            Worker worker = new Worker("Worker " + i, new Random().nextInt(15,16)*i);
            DBManager.getInstance().saveWorker(worker);
            carWash.hireWorker(worker);
        }

        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            Service randomService = services.get(rand.nextInt(services.size()));
            VehicleType randomVehicleType = vehicleTypes.get(rand.nextInt(vehicleTypes.size()));
            VehicleOrder vo = new VehicleOrder("Random model", randomVehicleType, randomService);
            carWash.receiveOrder(vo);
        }

        Reporter reporter = new Reporter();
        reporter.setDaemon(true);
        reporter.start();
    }


}
