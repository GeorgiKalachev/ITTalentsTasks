package test2.farm.animals;

import java.util.Random;

public class Sheep extends Cattle{

    private boolean givenWool = false;

    @Override
    public int giveMilk() {
        if(isHungry()){
            return 0;
        }
        return 2;
    }

    public int giveWool(){
        if(givenWool){
            return 0;
        }
        int chance = new Random().nextInt(100);
        if(chance < 2){
            givenWool = true;
            return 20;
        }
        return 0;
    }
}
