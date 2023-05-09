package Rakia.Fruits;

public abstract class Fruit {

    public enum FRUITSTYPE { GROZDE, SLIVI, KAISII }

    private FRUITSTYPE type;

    public Fruit(FRUITSTYPE fruitType){
        this.type = fruitType;
    }
}
