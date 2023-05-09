package test2.farm.animals;

import java.util.Random;

public abstract class Cattle extends FarmAnimal{

    private boolean isHungry;

    public Cattle() {
        super(FarmAnimalType.CATTLE);
        this.isHungry = true;
    }

    public abstract int giveMilk();

    protected boolean isHungry() {
        return isHungry;
    }

    public void eat(){
        if(new Random().nextInt(10) != 1){
            isHungry = false;
        }
    }

    public void wakeUp(){
        isHungry = true;
    }
}
