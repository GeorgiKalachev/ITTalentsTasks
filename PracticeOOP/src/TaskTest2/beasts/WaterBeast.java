package TaskTest2.beasts;

public abstract class WaterBeast extends Beast{

    protected int maxDepth;

    public WaterBeast(String name, int age,double price) {
        super(name, BeastType.WATER, age,price);
    }

}
