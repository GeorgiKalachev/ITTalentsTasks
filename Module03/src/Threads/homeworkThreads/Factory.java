package Threads.homeworkThreads;

import Threads.homeworkThreads.parts.Part;

import java.util.ArrayList;
import java.util.List;

public class Factory extends Thread {


    public Factory(String name){
        super(name);
    }

    private final List<Part> parts = new ArrayList<>();



    public void addComponents(Part c){
        this.parts.add(c);
    }


    @Override
    public void run() {

            try {
                for (Part c : parts) {
                    Thread.sleep(c.getTimeToFinish());
                    System.out.println(Thread.currentThread().getName() + " constructed " + c.getName());
                }
            } catch (InterruptedException e) {
                System.out.println("opaaa");
            }

    }
}
