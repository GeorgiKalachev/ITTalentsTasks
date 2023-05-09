package Rakia;

import Rakia.Fruits.Fruit;

import java.util.Random;

public class Rakidjiq extends Person{




    public Rakidjiq(String name, int age, Rakidjiiinica factory) {
        super(name, age, factory);
    }

    @Override
    public void run() {

            while (true) {
                if(isInterrupted()){
                    return;
                }
                int litri = new Random().nextInt(3,6);
                Fruit f = getFactory().izprazniBidona();
                System.out.println("Svarihme " + f);
                getFactory().addToProduce(litri);
            }

    }
}
