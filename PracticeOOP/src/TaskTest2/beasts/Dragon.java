package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Dragon extends AirBeast{


    public Dragon(String name) {
        super(name, 50, 150);
    }

    @Override
    public void entertainClient(Client client) {
        System.out.println("Dragon gives preccios Ring to " + client.getName());
    }
}
