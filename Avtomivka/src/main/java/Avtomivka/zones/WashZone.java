package Avtomivka.zones;

public class WashZone {

    private int carsIn = 0;

    private final int maxCarsIn ;

    public WashZone( int maxCarsIn) {

        this.maxCarsIn = maxCarsIn;
    }

    public synchronized void put() {
        try {
            while (carsIn >= maxCarsIn) {
                wait();

            }
            carsIn++;
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("ole");
        }
    }
    public synchronized void take(){

        try {
            while (carsIn == 0){
                wait();

            }
            carsIn--;
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("male");
        }

    }
}
