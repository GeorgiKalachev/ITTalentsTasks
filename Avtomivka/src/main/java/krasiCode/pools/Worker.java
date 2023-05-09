package krasiCode.pools;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {

    private BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            if(isInterrupted()){
                return;
            }
            Runnable t = null;
            try {
                t = queue.take();
            } catch (InterruptedException e) {
                System.out.println("");
                return;
            }
            t.run();
        }
    }
}
