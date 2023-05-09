package main.cleaning;

import main.cleaning.clothes.Clothing;

public class DryCleaning {

    private String name;
    private Order[] orders = new Order[1000];
    private int nextOrderIndex = 0;
    private int totalCleaningTime = 0;
    private Client[] clients = new Client[1000];
    private int nextClientIndex = 0;
    private int[] clothesCleaned = new int[100];

    public DryCleaning(String name){
        //TODO validate
        this.name = name;
    }

    public void receiveOrder(Client client){
        Order order = new Order(client);
        this.orders[nextOrderIndex++] = order;
        for (int i = 0; i < client.getClothes().length; i++) {
            this.totalCleaningTime += client.getClothes()[i].getTimeToClean();
            this.clothesCleaned[client.getClothes()[i].getId()]++;
        }
        registerClient(client);
        client.pay(order.getTotalPrice());
    }

    private void registerClient(Client client){
        for (int i = 0; i < nextClientIndex; i++) {
            if(this.clients[i].equals(client)){
                return;
            }
        }
        this.clients[nextClientIndex++] = client;
    }


    public void showTotalCleaningTime() {
        System.out.println("Total cleaning time = " + this.totalCleaningTime);
    }

    public void showClothesByType() {
        System.out.println("-----------Total cleaned-----------");
        for (int i = 0; i < Clothing.CLOTHING_TYPES.length; i++) {
            System.out.println(Clothing.CLOTHING_TYPES[i] + " - " + this.clothesCleaned[i]);
        }
    }

    public void showTotalClients(){
        System.out.println("Total clients = " + nextClientIndex);
    }

    public void getMostGenerousClient(){
        if(nextClientIndex > 0) {
            Client mostGenerous = this.clients[0];
            for (int i = 1; i < nextClientIndex; i++) {
                if (this.clients[i].getExpenses() > mostGenerous.getExpenses()) {
                    mostGenerous = this.clients[i];
                }
            }
            System.out.println("Most generous = " + mostGenerous.getId());
        }
        else{
            System.out.println("No clients yet");
        }
    }
}
