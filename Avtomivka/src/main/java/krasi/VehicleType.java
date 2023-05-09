package krasi;
public class VehicleType {

    public enum VehicleTypeName {
        CAR, TRUCK, JEEP
    }
    private int id;
    private VehicleTypeName name;

    public VehicleType(VehicleTypeName name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleTypeName getName() {
        return name;
    }
}
