package TaskTest2;

public class Demo {
    public static void main(String[] args) {


        Park park = new Park("Krasi`s Fantastic Beasts","Sofia");

        park.addNormalAttractions();
        park.addExtremeAttractions();
        park.addClients();
        park.clientsEnterAttraction();
        park.startAttractions();


        park.statistics();


    }
}
