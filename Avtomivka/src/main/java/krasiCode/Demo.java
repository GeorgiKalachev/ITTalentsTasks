package krasiCode;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    static AtomicInteger x = new AtomicInteger(5);

    public static void main(String[] args) {

        //Atomic Operation

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> x.getAndIncrement()).start();
        }
        System.out.println(x);


    }
}
