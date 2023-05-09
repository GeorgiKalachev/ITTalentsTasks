package Skara.Gotvachi;

import Skara.Products.Product;
import Skara.SkaraFactory;

public class HlebarGotvach extends Thread {

    private SkaraFactory skaraFactory;
    public HlebarGotvach(SkaraFactory skaraFactory) {
        this.skaraFactory = skaraFactory;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product product = Product.getRandomBread();
                Thread.sleep(product.getTimeToCook() * 1000);
                System.out.println("Cooked " + product.getClass().getSimpleName() + " for " + product.getTimeToCook() + " sec");
                skaraFactory.putBread(product);
            }
        } catch (InterruptedException e) {
            System.out.println("opa");
        }
    }
}
