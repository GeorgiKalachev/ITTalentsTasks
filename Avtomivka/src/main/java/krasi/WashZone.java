package krasi;
public class WashZone {
    private int carsIn = 0;
    private final int maxCars;

    public WashZone(int maxCars){
        this.maxCars = maxCars;
    }

    public synchronized void put(){
        try {
            while(carsIn >= maxCars){
                wait();
            }
            carsIn++;
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("ole male");
        }
    }

    public synchronized void take(){
        try {
            while(carsIn == 0){
                wait();
            }
            carsIn--;
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("ole male");
        }
    }
}
