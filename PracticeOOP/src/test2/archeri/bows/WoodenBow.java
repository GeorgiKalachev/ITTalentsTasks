package test2.archeri.bows;

public class WoodenBow extends Bow {


    public WoodenBow(double weight, String manufacturer, int strength) {
        super(weight, manufacturer, strength);
    }

    @Override
    protected int getMinStrength() {
        return 20;
    }

    @Override
    protected int getMaxStrength() {
        return 30;
    }

    @Override
    public BowType getBowType() {
        return BowType.WOODEN;
    }

    @Override
    public int getBonuses() {
        return 0;
    }
}
