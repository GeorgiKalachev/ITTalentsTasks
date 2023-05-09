package kidsGarden;

import java.util.Random;

public class Teacher {

    private final String name;

    Teacher(String name){
        this.name = name;
    }

    public void entertainingKid(Kid kid){
        int chance = new Random().nextInt(100);

        if (kid.isGood() && chance < 70){
            kid.isGifted();
        }
        if (!kid.isGood() && chance < 40){
            kid.isGifted();
        }
        int chanceTreat = new Random().nextInt(100);
        if (!kid.isGood() && chanceTreat < 25){
            kid.isPunished();
        }

    }
}
