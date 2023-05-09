package TaskTest2.beasts;

public abstract class EarthBeast extends Beast{


    public EarthBeast(String name, int age,double price) {
        super(name, BeastType.EARTH, age,price);
    }
}
