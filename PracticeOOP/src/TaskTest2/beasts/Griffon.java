package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Griffon extends AirBeast{


    public Griffon(String name) {
        super(name,  80,180);
    }

    @Override
    public void entertainClient(Client client) {
        System.out.println(client.getName() + " rides the Griffon");
    }
}
