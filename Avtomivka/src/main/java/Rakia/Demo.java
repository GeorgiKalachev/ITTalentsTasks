package Rakia;

import Rakia.Fruits.Fruit;
import Rakia.Fruits.Grozde;
import Rakia.Fruits.Kaisiq;
import Rakia.Fruits.Sliva;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {

        Rakidjiiinica factory = new Rakidjiiinica();


        for (int i = 0; i < 7; i++) {
            Berach berach = new Berach("Berach " + (i+1),new Random().nextInt(15,55),factory,getRandomFruit());
            DBManager.getInstance().savePerson(berach);
            //factory.addPerson(berach);
            berach.start();
        }

        for (int i = 0; i < 3; i++) {
            Rakidjiq rakidjiq = new Rakidjiq("Rakidjiq " + (i+1),new Random().nextInt(15,55),factory);
            DBManager.getInstance().savePerson(rakidjiq);
            //factory.addPerson(rakidjiq);
            rakidjiq.start();
        }





    }

    private static Fruit getRandomFruit() {
        int chance = new Random().nextInt(3);
        switch (chance){
            case 0 -> {
                return new Grozde();
            }
            case 1 -> {
                return new Kaisiq();
            }
            default -> {
                return new Sliva();
            }
        }
    }



}
