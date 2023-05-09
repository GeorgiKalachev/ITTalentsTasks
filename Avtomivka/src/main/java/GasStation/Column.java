package GasStation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Column {

    BlockingQueue<Car> cars = new ArrayBlockingQueue<>(1);
    private String name;
    private Worker worker = null;

    public Column(String name){
        this.name = name;
    }

    public synchronized void putCar(Car car){
        try {
            cars.put(car);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void takeCar(){
        try {
           cars.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public BlockingQueue<Car> getCars() {
        return cars;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }


    public Worker getServicedBy() {
        return this.worker;
    }

    public void setServicedBy(Worker worker) {
        this.worker = worker;
    }
}
