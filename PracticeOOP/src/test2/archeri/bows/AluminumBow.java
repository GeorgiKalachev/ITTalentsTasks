package test2.archeri.bows;

public class AluminumBow extends Bow {

    protected int scope = 1;

    public AluminumBow(double weight, String manufacturer, int strength) {
        super(weight, manufacturer, strength);
    }

    @Override
    protected int getMinStrength() {
        return 25;
    }

    @Override
    protected int getMaxStrength() {
        return 40;
    }

    @Override
    public BowType getBowType() {
        return BowType.ALUMINUM;
    }

    @Override
    public int getBonuses() {
        return scope;
    }
}
