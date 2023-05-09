package GasStation.gass;

import java.util.ArrayList;
import java.util.List;
public class Shop {
    private List<Integer> columns;
    private int numCarsWaiting;
    private List<Worker> worker = new ArrayList<>();
    public Shop() {
        columns = new ArrayList<Integer>();
        columns.add(0);
        columns.add(0);
        columns.add(0);
        columns.add(0);
        columns.add(0);
        numCarsWaiting = 0;
        for (int i = 0; i < 2; i++) {
            worker.add(new Worker(this));
            worker.get(i).start();
        }
    }

    public synchronized int getAvailableColumn() {
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i) == 0) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void fillColumn(int column) {
        columns.set(column, 1);
    }

    public synchronized void emptyColumn(int column) {
        columns.set(column, 0);
    }

    public synchronized void addCar() {
        numCarsWaiting++;
        System.out.println("Car coming");
    }

    public synchronized boolean isCarWaiting() {
        return numCarsWaiting > 0;
    }

    public synchronized void removeCar() {
        numCarsWaiting--;
    }
}
