package main.cleaning;

import main.cleaning.clothes.Clothing;

import java.util.Objects;
import java.util.Random;

public class Client {

    private static int uniqueID = 1;

    private int id;
    private Clothing[] clothes;
    private double expenses = 0;


    public Client(){
        System.out.println("Client created");
        this.clothes = new Clothing[new Random().nextInt(3,9)];
        for (int i = 0; i < clothes.length; i++) {
            clothes[i] = Clothing.getRandomCloth();
        }
        this.id = uniqueID++;
    }

    public double getExpenses() {
        return expenses;
    }

    public Clothing[] getClothes() {
        return clothes;
    }

    public void pay(double price){
        if(price > 0) {
            this.expenses += price;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
