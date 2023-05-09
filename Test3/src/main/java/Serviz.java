import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Serviz {

    private Priemchik priemchik;
    private Dispetcher dispetcher;
    private List<Worker> workers = new ArrayList<>();
    private List<Diagnostic> diagnostics = new ArrayList<>();


    private Zona podryjkaZone = new Zona();
    private Zona remontZone = new Zona();


    private ArrayBlockingQueue<Order> carsForDiagnostic = new ArrayBlockingQueue<>(3);
    private ArrayBlockingQueue<Car> carsComing = new ArrayBlockingQueue<>(20);

    private LinkedList<Order> readyOrders = new LinkedList<>();


    public Serviz() {
        priemchik = new Priemchik("Priemchik", this);

        dispetcher = new Dispetcher(this);

        for (int i = 0; i < 2; i++) {
            diagnostics.add(new Diagnostic("Diagnostik " + (i + 1), new Random().nextInt(20, 50), this));
            diagnostics.get(i).start();
            DBManager.saveDiagnostic(diagnostics.get(i));
        }

        for (int i = 0; i < 2; i++) {
            workers.add(new Worker(this, remontZone, "Remont worker " + i, new Random().nextInt(20, 50)));
            workers.get(i).start();
            DBManager.saveWorker(workers.get(i));
        }

        for (int i = 0; i < 2; i++) {
            workers.add(new Worker(this, podryjkaZone, "Podryjka worker " + i, new Random().nextInt(20, 50)));
            workers.get(i + 2).start();
            DBManager.saveWorker(workers.get(i + 2));
        }

    }


    public Car getCarsComing() {

        try {
            return carsComing.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeCarToDiagnostic(Order order) {

        carsForDiagnostic.add(order);

    }

    public Order getCarForDiagnostic() {
        try {
            return carsForDiagnostic.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Order getRedyOrder() {
        try {
            while (readyOrders.isEmpty()) {
                wait();
            }
            Order order = this.readyOrders.getFirst();
            readyOrders.removeFirst();
            return order;

        } catch (InterruptedException e) {
            System.out.println("basi");
        }
        return null;
    }

    public void comingCar(Car car1) {

        carsComing.add(car1);

    }

    public Zona getZone() {
        if (new Random().nextBoolean()) {
            return remontZone;
        } else {
            return podryjkaZone;
        }
    }

    public void addReadyOrder(Order order) {
        readyOrders.add(order);
    }

    public void addToFile(Order order) {
        readyOrders.remove(order);

        File f = new File(order.getCarId() + "-" + LocalDateTime.now() + ".txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            order.setExitAtTime(LocalDateTime.now());
            DBManager.saveOrder(order);
        } catch (IOException e) {
            System.out.println("ulala");
        }

    }
}
