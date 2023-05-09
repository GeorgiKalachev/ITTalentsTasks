package test2.farm.animals;

import java.util.Random;

public abstract class WorkingAnimal extends FarmAnimal{

    private boolean isTired = false;

    public WorkingAnimal() {
        super(FarmAnimalType.WORKING);
    }

    public void setTired(boolean tired) {
        isTired = tired;
    }

    public boolean isTired() {
        return isTired;
    }

    public void plough(){
        if(isTired){
            return;
        }
        isTired = true;
    }

    public void takeCare(){//polivane s voda
        if(isTired) {
            int chance = new Random().nextInt(100);
            if (chance < 60) {
                    isTired = false;
            }
        }
    }
}
