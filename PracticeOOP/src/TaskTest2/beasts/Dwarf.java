package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Dwarf extends EarthBeast{

    public Dwarf(String name) {
        super(name, 120,60);
    }

    @Override
    public void entertainClient(Client client) {
        System.out.println("Dwarf makes golden ring and gives it to " + client.getName());
    }
}
