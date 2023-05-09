package test2.archeri.bows;

public abstract class Bow {

    public enum BowType { WOODEN, ALUMINUM, CARBON}

    private double weight;
    private String manufacturer;
    private int strength;

    public Bow(double weight, String manufacturer, int strength) {
        this.weight = weight;
        this.manufacturer = manufacturer;
        if (validStrength(strength)) {
            this.strength = strength;
        }
        else{
            this.strength = (getMaxStrength() + getMinStrength()) / 2;
        }
    }

    private boolean validStrength(int strength){
        return strength >= getMinStrength() && strength <= getMaxStrength();
    }

    protected abstract int getMinStrength();
    protected abstract int getMaxStrength();
    public abstract BowType getBowType();

    public abstract int getBonuses();

}
