package avtomivka;

import java.time.LocalDateTime;

public class VehicleOrder {

    private int id;
    private String model;
    private VehicleType vehicleType;
    private Service service;
    private LocalDateTime registeredAt;
    private LocalDateTime servicedAt;
    private Worker servicedBy;

    public VehicleOrder(String model, VehicleType vehicleType, Service service) {
        this.model = model;
        this.vehicleType = vehicleType;
        this.service = service;
        this.registeredAt = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
