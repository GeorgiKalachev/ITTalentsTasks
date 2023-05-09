package skari;

import skari.products.Product;

import java.util.ArrayList;
import java.util.List;

public class SaladCook extends Thread {

    public static Shop shop;

    @Override
    public void run() {
        try {
            while (true){
                Product p = Product.getRandomSalad();
                Thread.sleep(p.getCookTime());
                List list = new ArrayList();
                list.add(p);
                shop.add(list);
            }
        }
        catch (InterruptedException e){
            System.out.println("moje");
        }
    }
}
