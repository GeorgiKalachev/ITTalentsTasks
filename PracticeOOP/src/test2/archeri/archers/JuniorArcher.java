package test2.archeri.archers;

import test2.archeri.bows.WoodenBow;

import java.util.Random;

public class JuniorArcher extends Archer{

    public JuniorArcher(String name, Gender gender, WoodenBow bow, int age) {
        super(name, gender, age, bow, 1, ArcherType.JUNIOR);
    }

    @Override
    public int getMaxArrows() {
        return 30;
    }

    @Override
    protected int getRandomScore() {
        int missChance = new Random().nextInt(10);
        if(missChance < 1){
            return 0;//miss
        }
        return new Random().nextInt(10)+1;
    }
}
