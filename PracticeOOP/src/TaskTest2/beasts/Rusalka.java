package TaskTest2.beasts;

import TaskTest2.clients.Client;

public class Rusalka extends WaterBeast{

    private String hairColour;

    public Rusalka(String name) {
        super(name,  18,30);
    }

    @Override
    public void entertainClient(Client client) {
        System.out.println("The seamermaid sings a song to  " + client.getName());
    }

}
