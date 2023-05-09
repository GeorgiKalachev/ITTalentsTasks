package test2.archeri.archers;

import test2.archeri.bows.CarbonBow;

import java.util.Random;

public class VeteranArcher extends Archer {

    public VeteranArcher(String name, Gender gender, int age, CarbonBow bow) {
        super(name, gender, age, bow, 10, ArcherType.VETERAN);
    }

    @Override
    public int getMaxArrows() {
        return 60;
    }

    @Override
    protected int getRandomScore() {
        return new Random().nextInt(5)+6;
    }
}
