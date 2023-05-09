package test2.archeri.bows;

public class CarbonBow extends AluminumBow {

    private int stabilizer = 1;

    public CarbonBow(double weight, String manufacturer, int strength) {
        super(weight, manufacturer, strength);
        this.scope = 2;
    }

    @Override
    protected int getMinStrength() {
        return 28;
    }

    @Override
    protected int getMaxStrength() {
        return 48;
    }

    @Override
    public int getBonuses() {
        return super.getBonuses() + stabilizer;
    }

    @Override
    public BowType getBowType() {
        return BowType.CARBON;
    }
}
