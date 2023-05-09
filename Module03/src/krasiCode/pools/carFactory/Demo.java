package krasiCode.pools.carFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ExecutorService carFactory = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 4; i++) {
            carFactory.execute(() -> {
                try {
                    Thread.sleep(new Tire().getConstructionTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (int i = 0; i < 5; i++) {
            carFactory.execute(() -> {
                try {
                    Thread.sleep(new Seat().getConstructionTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        carFactory.execute(() -> {
            try {
                Thread.sleep(new Engine().getConstructionTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        carFactory.execute(() -> {
            try {
                Thread.sleep(new Frame().getConstructionTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        carFactory.shutdown();
        carFactory.awaitTermination(20, TimeUnit.SECONDS);

        System.out.println("Duration = " + (System.currentTimeMillis() - start));
    }
}
