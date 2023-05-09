package avtomivka;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CarWash {

    private int id;
    private String name;
    private WashZone inner;
    private WashZone outer;
    private Set<Worker> workers = new HashSet<>();
    private List<PriceListItem> priceList = new ArrayList<>();
    private List<WashTime> washTimes = new ArrayList<>();
    private BlockingQueue<VehicleOrder> orders;

    public void setId(int id) {
        this.id = id;
    }

    public CarWash(String name){
        this.name = name;
        inner = new WashZone(2);
        outer = new WashZone(3);
        orders = new ArrayBlockingQueue(10);
    }

    public void addPriceListItem(PriceListItem priceListItem){
        priceList.add(priceListItem);
    }

    public void addWashTime(WashTime washTime){
        washTimes.add(washTime);
    }

    public void receiveOrder(VehicleOrder vo){
        try{
            orders.put(vo);
            System.out.println("Order received");
            DBManager.getInstance().saveOrder(vo);
        }
        catch (InterruptedException e){
            System.out.println("ujas");
        }
    }

    public VehicleOrder getNextOrder(){
        try{
            System.out.println(Thread.currentThread().getName() + " - order taken");
            VehicleOrder vo = orders.take();
            double price = DBManager.getInstance().getPrice(vo.getService(), vo.getVehicleType());
            System.out.println("This service costs " + price);
            return vo;
        }
        catch (InterruptedException e){
            System.out.println("ujas");
            return null;
        }
    }

    public void hireWorker(Worker worker){
        this.workers.add(worker);
        worker.start();
    }

    public WashZone getInner() {
        return inner;
    }

    public WashZone getOuter() {
        return outer;
    }

    public long getWashTime(Service.ServiceName sName, VehicleType.VehicleTypeName vtName) {
//        System.out.println("Trying to get wash time for " + sName + " and " + vtName);
        return this.washTimes.stream()
                .filter(wt -> wt.getVehicleType() == vtName && wt.getService() == sName)
                .findFirst()
                .get()
                .getWashTime();
    }

    public String getName() {
        return name;
    }
}
