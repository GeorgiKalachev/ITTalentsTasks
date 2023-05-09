package Rakia;

import Rakia.Fruits.Fruit;
import Rakia.Fruits.Grozde;

public class Berach extends Person {


    private Fruit fruitToGather;
    private Rakidjiiinica kazan;

    public Berach(String name, int age, Rakidjiiinica kazan,Fruit fruitToGather) {
        super(name, age, kazan);
        this.fruitToGather = fruitToGather;
    }


    @Override
    public void run() {
        while (true){
            //бери на 1.5 сек по 1 кг. докато не стигне 10 кг.

            try {
                if(isInterrupted()){
                    return;
                }
                Thread.sleep(200);
                getFactory().putInSuitableKazan(fruitToGather);
            }
            catch (InterruptedException e){
                System.out.println("male");
                return;
            }
        }
    }
}
