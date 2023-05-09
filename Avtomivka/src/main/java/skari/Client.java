package skari;

import skari.products.Product;

public class Client extends Thread {

    public static Shop shop;


    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(3000);
                shop.order(Product.getRandomBread(),
                            Product.getRandomMeat(),
                            Product.getRandomSalad());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
