package test2.farm.animals;

public class Cow extends Cattle{

    @Override
    public int giveMilk() {
        if(isHungry()) {
            return 0;
        }
        return 5;
    }
}
