package snowwhite.presents;

import snowwhite.Kid;

public class Car extends Present{

    private int batteries;

    public Car(double price, Kid kid, int batteries) {
        super(price, kid);
        this.batteries =  batteries >= 2 && batteries <= 6 ? batteries : 4;
    }

    @Override
    protected double getMinPrice() {
        return 20;
    }

    @Override
    protected double getMaxPrice() {
        return 40;
    }
}
