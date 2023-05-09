package Avtomivka;

import Avtomivka.zones.WashZone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Avtomivka {

    private int ID;
    private String name;

    private WashZone innerZone;
    private WashZone outerZone;
    private Set<Worker> workers = new HashSet<>();
    List<PriceListItem> priceListItem = new ArrayList<>();

    public void setOuterZone(WashZone outerZone) {
        this.outerZone = outerZone;
    }

    private BlockingQueue<VehicleOrder> orders;

    public Avtomivka() {
        this.innerZone = new WashZone(2);
        this.outerZone = new WashZone(3);
        this.orders = new ArrayBlockingQueue<>(10);
    }

    public void addPriceListItem (PriceListItem prlst){
        this.priceListItem.add(prlst);
    }

    public void recieveOrder(VehicleOrder vo){
        try {
            orders.put(vo);
            DBManager.getInstance().saveOrder(vo);
            DBManager.getInstance().getPrice(vo.getService(),vo.getType());
            System.out.println("Order received and saved.");


        }
        catch (InterruptedException e) {
            System.out.println("ole");
        }
    }

    public VehicleOrder takeNextOrder(){
        try {
            return orders.take();
        }
        catch (InterruptedException e) {
            System.out.println("male");
            return null;
        }
    }
    public void hireWorker(Worker worker){
        this.workers.add(worker);
        worker.start();
        System.out.println(worker.getName() + "hired and start.");
    }

    public WashZone getInnerZone() {
        return innerZone;
    }

    public WashZone getOuterZone() {
        return outerZone;
    }
}
