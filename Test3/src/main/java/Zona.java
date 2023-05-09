import java.util.LinkedList;

public class Zona {
    private LinkedList<Order> cars = new LinkedList<>();

    public synchronized void put(Order order){

            cars.add(order);
            notifyAll();

    }

    public synchronized Order take(){
        try {
            while(cars.isEmpty()){
                wait();
            }
            cars.removeFirst();
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("ole male");
        }
        return null;
    }
}
