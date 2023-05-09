package krasiCode.pools.carFactory;

import java.util.concurrent.*;

public class TimerDemo {


    public static void main(String[] args) {

        ExecutorService s = Executors.newFixedThreadPool(3);

        Callable<Integer> callable = () -> {
            //sleep for 5 seconds
            return 5;
        };

        Future<Integer> future = s.submit(callable);

        //.....  ......

    }



}
