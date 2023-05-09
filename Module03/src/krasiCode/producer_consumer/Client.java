package krasiCode.producer_consumer;

public class Client extends Thread{

    private Shop shop;

    public Client(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Product p = shop.sellProduct();
            System.out.println("Client bought a cucumber");
        }
    }
}
