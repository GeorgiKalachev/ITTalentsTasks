package GasStation.gass;

public class Worker extends Thread{
    private Shop gasStation;

    public Worker(Shop gasStation) {
        this.gasStation = gasStation;
    }

    public void run() {
        while (true) {
            if (gasStation.isCarWaiting()) {
                int column = gasStation.getAvailableColumn();
                if (column >= 0) {
                    gasStation.removeCar();
                    gasStation.fillColumn(column);
                    System.out.println("Worker " + Thread.currentThread().getId() + " is filling column " + column);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gasStation.emptyColumn(column);
                    System.out.println("Worker " + Thread.currentThread().getId() + " emptied column " + column);
                }
            }
        }
    }
}