package test2.archeri.archers;

import test2.archeri.bows.AluminumBow;

import java.util.Random;

public class SeniorArcher extends Archer {

        public SeniorArcher(String name, Gender gender, int age, AluminumBow bow) {
        super(name, gender, age, bow, 3, ArcherType.SENIOR);
    }


    @Override
    public int getMaxArrows() {
        return 60;
    }

    @Override
    protected int getRandomScore() {
        int missChance = new Random().nextInt(20);
        if(missChance == 1){
            return 0;//miss
        }
        return new Random().nextInt(5)+6;
    }
}
