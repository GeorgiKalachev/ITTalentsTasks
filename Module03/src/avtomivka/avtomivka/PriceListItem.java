package avtomivka;

public class PriceListItem {

    private Service service;
    private VehicleType vehicleType;
    private double price;

    public PriceListItem(Service service, VehicleType vehicleType, double price) {
        this.service = service;
        this.vehicleType = vehicleType;
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getPrice() {
        return price;
    }
}
