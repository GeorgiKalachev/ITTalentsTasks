package TaskTest2.attractions;

import TaskTest2.beasts.Beast;
import TaskTest2.clients.Client;

import java.util.LinkedList;
import java.util.Random;

public abstract class Atraction {

    protected String name;
    protected double price;
    protected LinkedList<Client> clients;
    protected Beast beast;
    protected int chanceToKill;
    protected double money = 0;

    public Atraction(String name, Beast beast) {
        this.name = name;
        this.price = beast.getPrice();
        this.clients = new LinkedList<>();
        this.beast = beast;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addingClients(Client client){
        this.clients.add(client);
    }

    public int getChanceToKill() {
        return chanceToKill;
    }

    public void beastEnterteinClients(){
        int chance = new Random().nextInt(100);
        for (Client client:clients) {
            this.beast.entertainClient(client);
            if(chance < this.getChanceToKill()){
                client.isKilled();
                System.out.println(client.getName() + " is killed");
            }
            double cost = client.payAttraction(this.price);
            this.money += cost;
        }
    }

    public double getMoney() {
        return money;
    }

    public Beast getBeast() {
        return beast;
    }

}
