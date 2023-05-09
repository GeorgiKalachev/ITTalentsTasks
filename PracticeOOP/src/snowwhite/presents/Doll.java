package snowwhite.presents;

import snowwhite.Kid;

public class Doll extends Present{

    private String hairColor;
    private String dimensions;

    public Doll(double price, Kid kid, String hairColor, String dimensions) {
        super(price, kid);
        this.hairColor = hairColor;
        this.dimensions = dimensions;
    }

    @Override
    protected double getMinPrice() {
        return 5;
    }

    @Override
    protected double getMaxPrice() {
        return 10;
    }
}
