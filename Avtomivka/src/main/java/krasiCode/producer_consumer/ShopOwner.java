package krasiCode.producer_consumer;

public class ShopOwner extends Thread {

    private Storage storage;
    private Shop shop;

    public ShopOwner(Storage storage, Shop shop) {
        this.storage = storage;
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true){
            Product p = storage.takeProduct();
            System.out.println("Shop owner got a cucumber from the storage");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ej shh!");
            }
            shop.supplyProduct(p);
            System.out.println("Shop owner supplied a cucumber from the shop");
        }
    }
}