package test2.farm.services;

public class PloughService extends Service{

    private int squareKm;

    public PloughService(int squareKm) {
        this.squareKm = squareKm;
    }

    @Override
    public ServiceType getType() {
        return ServiceType.PLOUGH;
    }

    public int getSquareKm() {
        return squareKm;
    }
}
