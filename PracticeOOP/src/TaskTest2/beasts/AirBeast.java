package TaskTest2.beasts;

public abstract class AirBeast extends Beast{

    protected int maxFlySpeed;

    public AirBeast(String name,int age,double price ) {
        super(name, BeastType.AIR, age,price);
    }

}
