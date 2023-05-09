package Threads.homeworkThreads;

import Threads.homeworkThreads.parts.Engine;
import Threads.homeworkThreads.parts.Frame;
import Threads.homeworkThreads.parts.Seat;
import Threads.homeworkThreads.parts.Tyre;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Factory t1 = new Factory("Line 1");
        t1.addComponents(new Engine());
        t1.addComponents(new Seat());
        t1.addComponents(new Tyre());
        Factory t2 = new Factory("Line 2");
        t2.addComponents(new Frame());
        t2.addComponents(new Seat());
        t2.addComponents(new Tyre());
        t2.addComponents(new Tyre());
        Factory t3 = new Factory("Line 3");
        t3.addComponents(new Seat());
        t3.addComponents(new Seat());
        t3.addComponents(new Seat());
        t3.addComponents(new Tyre());

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long end = System.currentTimeMillis() - start;
        System.out.println("Car is done in : " + end);


    }
}
