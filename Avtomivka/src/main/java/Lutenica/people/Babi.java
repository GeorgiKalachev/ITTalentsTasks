package Lutenica.people;

import Lutenica.Fabric;

public class Babi extends Thread{

    private int id;
    private Fabric fabric;
    private int age;
    private String name;

    public Babi(String name,int age,Fabric fabric){
        setName(name);
        this.age = age;
        this.fabric = fabric;
    }

    @Override
    public void run() {

        while (true){
            fabric.makeLutenica();
            try {
                Thread.sleep(10000);
                System.out.println("Lutanica beshe napravena ot : " +Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
