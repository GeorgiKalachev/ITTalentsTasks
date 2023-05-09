package Pristanishte;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {


        Pristanishte pristanishte = new Pristanishte();


        for (int i = 0; i < 10; i++) {
            pristanishte.addKorab(new Korab(new Random().nextInt(1,5)));
            try {
                Thread.sleep(2500);
            }catch (InterruptedException e){
                System.out.println("male");
            }
        }
    }
}
