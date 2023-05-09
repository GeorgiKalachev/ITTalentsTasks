public class ServiceType {

    public enum REMONT_TYPE { REMONT,PODRYJKA};

    private int id;
    private REMONT_TYPE remontType;
    private String name;
    private double price;
    private int timeToRepair;

    public ServiceType(REMONT_TYPE remontType, String name, double price, int timeToRepair) {
        this.remontType = remontType;
        this.name = name;
        this.price = price;
        this.timeToRepair = timeToRepair;
    }

    public void setId(int id) {
        this.id = id;
    }

    public REMONT_TYPE getRemontType() {
        return remontType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTimeToRepair() {
        return timeToRepair;
    }
}
