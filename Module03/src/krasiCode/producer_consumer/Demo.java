package krasiCode.producer_consumer;

public class Demo {

    public static void main(String[] args) {

        Storage storage = new Storage();
        Shop shop = new Shop();

        Farmer farmer = new Farmer(storage);
        farmer.start();

        ShopOwner shopOwner = new ShopOwner(storage, shop);
        shopOwner.start();

        Client client = new Client(shop);
        client.start();

    }
}
