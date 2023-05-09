package Lutenica.people;

import Lutenica.Fabric;
import Lutenica.products.Chushka;
import Lutenica.products.Domat;
import Lutenica.products.Patladjan;
import Lutenica.products.Product;

import java.util.Random;

public class Momi extends Thread{

    private int id;
    private int age;
    private Fabric fabric;

    public Momi(String name, int age,Fabric fabric){
        setName(name);
        this.fabric = fabric;
        this.age = age;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Product product;
                int chance = new Random().nextInt(3);
                switch (chance) {
                    case 0 -> product = new Domat(3);
                    case 1 -> product = new Chushka(6);
                    default -> product = new Patladjan(9);
                }
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " slept and made product ");
                fabric.madeProduct(product, new Random().nextInt(2, 7));
                System.out.println(" what ?");
            } catch (InterruptedException e) {
                System.out.println("ok");
            }
        }
    }
    }

