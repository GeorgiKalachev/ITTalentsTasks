package Skara.Gotvachi;

import Skara.Products.Product;
import Skara.SkaraFactory;

public class MeatGotvach extends Thread {

    SkaraFactory skaraFactory;

    public MeatGotvach(SkaraFactory skaraFactory) {
        this.skaraFactory = skaraFactory;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Product product = Product.getRandomMeat();
                Thread.sleep(product.getTimeToCook() * 1000);
                System.out.println("Cooked " + product.getClass().getSimpleName() + " for " + product.getTimeToCook() + " sec");
                skaraFactory.putMeat(product);
            }
        } catch (InterruptedException e) {
            System.out.println("opa");
        }


    }
}
