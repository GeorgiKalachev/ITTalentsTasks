package snowwhite.presents;

import snowwhite.Kid;

public class Train extends Present{

    private boolean isSmoking;

    public Train(double price, Kid kid, boolean isSmoking) {
        super(price, kid);
        this.isSmoking = isSmoking;
    }

    @Override
    protected double getMinPrice() {
        return 15;
    }

    @Override
    protected double getMaxPrice() {
        return 30;
    }
}
