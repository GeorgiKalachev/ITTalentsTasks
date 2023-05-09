package krasiCode.blockingBob;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Gurne {

    private BlockingQueue<Integer> bob = new ArrayBlockingQueue<>(100);

    public void sipi(){
        try {
            bob.put(1);
            System.out.println("Sipahme bob, seba bobut e " + bob.size());
        } catch (InterruptedException e) {
            System.out.println("razbirate li!?");
        }
    }

    public void zemi(){
        try {
            bob.take();
            System.out.println("Vzehme bob, seba bobut e " + bob.size());
        } catch (InterruptedException e) {
            System.out.println("qko a?");
        }
    }
}
