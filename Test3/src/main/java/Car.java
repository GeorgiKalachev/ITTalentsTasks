public class Car {

    private int id;
    private String regNumber;
    private String model;
    private String ownerName;
    private String telNumber;
    private int year;
    private boolean isGuarantee;

    public Car(String regNumber, String model, String ownerName, String telNumber, int year, boolean isGuarantee) {
        this.regNumber = regNumber;
        this.model = model;
        this.ownerName = ownerName;
        this.telNumber = telNumber;
        this.year = year;
        this.isGuarantee = isGuarantee;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public int getYear() {
        return year;
    }

    public boolean isGuarantee() {
        return isGuarantee;
    }

    public void setId(int carId) {
    }

    public int getID() {
        return id;
    }
}
