package GasStation.gass.producer;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, waiting for producer to produce...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumed: " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
