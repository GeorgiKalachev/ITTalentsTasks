package Avtomivka;

import Avtomivka.cars.Vehicles;

public class PriceListItem {

    private Service service;

    private Vehicles vehicleType;

    private double price;

    public PriceListItem(Service s, Vehicles vt, double nextDouble) {

        this.service = s;
        this.vehicleType = vt;
        this.price = nextDouble;
    }

    public double getPrice() {
        return price;
    }
}
