package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Devil extends EarthBeast{



    public Devil(String name) {
        super(name,  1000,200);
    }

    @Override
    public void entertainClient(Client client) {
        System.out.println("Devil makes a wish to " + client.getName());
    }
}
