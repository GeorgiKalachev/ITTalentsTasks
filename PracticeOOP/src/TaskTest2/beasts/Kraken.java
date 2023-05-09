package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Kraken extends WaterBeast{

    private int lengthPipes;

    public Kraken(String name) {
        super(name, 250,250);
    }


    @Override
    public void entertainClient(Client client) {
        System.out.println("Kraken gives e pearl to " + client.getName());
    }
}
