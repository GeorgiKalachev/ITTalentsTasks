package snowwhite.presents;

import snowwhite.Kid;

public class Clothing extends Present{

    private String material;
    private String dimensions;

    public Clothing(double price, Kid kid, String material, String dimensions) {
        super(price, kid);
        this.material = material;
        this.dimensions = dimensions;
    }

    @Override
    protected double getMinPrice() {
        return 2;
    }

    @Override
    protected double getMaxPrice() {
        return 12;
    }
}
