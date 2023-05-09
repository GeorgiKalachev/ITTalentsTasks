package GasStation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Cashier {

    BlockingQueue<Car> cars = new ArrayBlockingQueue<>(5);
    private String name;

    public Car getCar(){
        return cars.peek();
    }
    public Cashier(String name){
        this.name = name;
    }

    public void putCar(Car car){
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
}
