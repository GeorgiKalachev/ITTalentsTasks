import java.time.LocalDateTime;

public class Order {


    private int id;
    private int carId;
    private LocalDateTime registeredAt;
    private LocalDateTime diagnosticAt;
    private int diagnostedByID;
    private int serviceTypeID;
    private LocalDateTime servicedAt;
    private int repairedByID;
    private LocalDateTime exitAtTime;


    public Order(int carId, LocalDateTime registeredAt) {
        this.carId = carId;
        this.registeredAt = registeredAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiagnosticAt(LocalDateTime diagnosticAt) {
        this.diagnosticAt = diagnosticAt;
    }

    public void setDiagnostedByID(int diagnostedByID) {
        this.diagnostedByID = diagnostedByID;
    }

    public void setServiceTypeID(int serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public void setServicedAt(LocalDateTime servicedAt) {
        this.servicedAt = servicedAt;
    }

    public void setRepairedByID(int repairedByID) {
        this.repairedByID = repairedByID;
    }

    public void setExitAtTime(LocalDateTime exitAtTime) {
        this.exitAtTime = exitAtTime;
    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public LocalDateTime getDiagnosticAt() {
        return diagnosticAt;
    }

    public int getDiagnostedByID() {
        return diagnostedByID;
    }

    public int getServiceTypeID() {
        return serviceTypeID;
    }

    public LocalDateTime getServicedAt() {
        return servicedAt;
    }

    public int getRepairedByID() {
        return repairedByID;
    }

    public LocalDateTime getExitAtTime() {
        return exitAtTime;
    }
}
