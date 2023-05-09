package main.cleaning;

import main.cleaning.clothes.Clothing;

public class Order {

    private Clothing[] clothes;
    private Client client;
    private double totalPrice;

    public Order(Client client) {
        this.client = client;
        this.clothes = client.getClothes();
        for (int i = 0; i < this.clothes.length; i++) {
            this.totalPrice += this.clothes[i].getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
