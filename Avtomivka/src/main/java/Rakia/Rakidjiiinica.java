package Rakia;

import Rakia.Fruits.Fruit;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Rakidjiiinica {
    private class Reporter extends Thread{

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(3000);
                    File f = new File(LocalDateTime.now().toString() + ".txt");

                }
            } catch (InterruptedException e) {
                System.out.println("fack");
            }
        }
    }

    private List<KazanRakia> kazani = new ArrayList<>();
    private Reporter reporter;
    private Map<Fruit,Integer> gathered = new HashMap<>();
    private Map<Fruit,Integer> produced = new HashMap<>();
    private List<Person> persons = new ArrayList<>();
    private volatile AtomicInteger totalRakiqProduced = new AtomicInteger(0);


    public Rakidjiiinica(){
        this.reporter = new Reporter();
        reporter.setDaemon(true);
        reporter.start();
        for (int i = 0; i < 5; i++) {
            kazani.add(new KazanRakia());
        }
    }

    public List<KazanRakia> getKazani() {
        return kazani;
    }

    public synchronized void putInSuitableKazan(Fruit fruitToGather) {
       try {
           Optional<KazanRakia> suitable =  this.kazani.stream()
                   .filter(c -> c.isEmpty() || c.getFruit() == fruitToGather)
                   .findFirst();
           while (!suitable.isPresent()){
               wait();
               suitable = this.kazani.stream()
                       .filter(c -> c.isEmpty() || c.getFruit() == fruitToGather)
                       .findFirst();
           }
            if(!gathered.containsKey(fruitToGather)){
                gathered.put(fruitToGather,0);
            }
            gathered.put(fruitToGather,gathered.get(fruitToGather)+1);
           suitable.get().putProduct(fruitToGather);
           System.out.println(Thread.currentThread().getName() + " Put " + fruitToGather.getClass().getName());
           notifyAll();
       }catch (InterruptedException e){
           System.out.println("male");
       }
    }

    public synchronized Fruit izprazniBidona() {
        try{
            Optional<KazanRakia> kazan = this.kazani.stream()
                    .filter(c -> c.isFull())
                    .findFirst();
            while (!kazan.isPresent()){
                wait();
                kazan = this.kazani.stream()
                        .filter(c -> c.isFull())
                        .findFirst();
            }
            Thread.sleep(1000);
            Fruit f = kazan.get().getFruit();
            System.out.println(Thread.currentThread().getName() + " izprazni " + kazan.getClass().getName() + " sys " + kazan.get().getFruit());

            kazan.get().empty();
            notifyAll();
            return f;
        }
        catch (InterruptedException e){
            System.out.println("ole");
        }

        return null;
    }

    public void addPerson(Person p){
        persons.add(p);
    }
    public void addToProduce(int value){
        totalRakiqProduced.incrementAndGet();
        System.out.println("Current rakia produced ------- " + totalRakiqProduced);
        if(totalRakiqProduced.get() >= 10){
            System.out.println("--- Game OVER ---");
            for (Person p : persons) {
                p.interrupt();
            }
        }
    }
}
