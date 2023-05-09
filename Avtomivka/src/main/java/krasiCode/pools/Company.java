package krasiCode.pools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Company {

    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue(100);
    private List<Worker> workers = new ArrayList<>();

    public Company(int workers){
        for (int i = 0; i < workers; i++) {
            this.workers.add(new Worker(queue));
        }
        for(Worker w : this.workers){
            w.start();
        }
    }

    public void addTask(Runnable r){
        try {
            queue.put(r);
        } catch (InterruptedException e) {
            System.out.println("lala");
        }
    }

    public void shutDown(){
        for(Worker w : workers){
            w.interrupt();
        }
    }
}
