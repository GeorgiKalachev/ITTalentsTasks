package avtomivka;

public class Service {

    public enum ServiceName{
        INNER, OUTER, COMBINED
    }

    private int id;
    private ServiceName name;

    public Service(ServiceName name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceName getName() {
        return name;
    }
}
