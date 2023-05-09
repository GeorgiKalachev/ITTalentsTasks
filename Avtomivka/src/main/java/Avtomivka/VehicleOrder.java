package Avtomivka;

import Avtomivka.cars.Vehicles;

import java.time.LocalDateTime;

public class VehicleOrder {

    private int id;
    private String model;
    private Vehicles type;
    private Service service;
    private LocalDateTime registredTime;
    private LocalDateTime servicedTime;
    private Worker workerServed;

    public VehicleOrder(String model,Vehicles vehType,Service service) {
        this.model = model;
        this.type = vehType;
        this.service = service;
        this.registredTime = LocalDateTime.now();
    }


    public Service getService() {
        return service;
    }

    public Vehicles getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }
}
