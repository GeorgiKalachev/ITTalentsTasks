package avtomivka;

public class WashTime {

    private Service.ServiceName service;
    private VehicleType.VehicleTypeName vehicleType;
    private int washTime;

    public WashTime(Service.ServiceName service, VehicleType.VehicleTypeName vehicleType, int washTime) {
        this.service = service;
        this.vehicleType = vehicleType;
        this.washTime = washTime;
    }

    public Service.ServiceName getService() {
        return service;
    }

    public VehicleType.VehicleTypeName getVehicleType() {
        return vehicleType;
    }

    public int getWashTime() {
        return washTime;
    }
}
