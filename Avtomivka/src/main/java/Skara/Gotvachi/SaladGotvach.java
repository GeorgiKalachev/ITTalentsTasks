package Skara.Gotvachi;

import Skara.Products.Product;
import Skara.SkaraFactory;

public class SaladGotvach extends Thread {

    SkaraFactory skaraFactory;

    public SaladGotvach(SkaraFactory skaraFactory) {
        this.skaraFactory = skaraFactory;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Product product = Product.getRandomSalad();
                Thread.sleep(product.getTimeToCook() * 1000);
                System.out.println("Cooked " + product.getClass().getSimpleName() + " for " + product.getTimeToCook() + " sec");
                skaraFactory.putSalad(product);
            }
        } catch (InterruptedException e) {
            System.out.println("opa");
        }


    }
}
