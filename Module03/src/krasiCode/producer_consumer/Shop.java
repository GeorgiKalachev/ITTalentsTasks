package krasiCode.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Product> products = new ArrayList();
    private static final int MAX_CAPACITY = 10;

    public synchronized void supplyProduct(Product p){
        while (products.size() >= MAX_CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("maika ti");
            }
        }
        products.add(p);
        notifyAll();
    }

    public synchronized Product sellProduct(){
        while (products.size() <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("chuhte li!");
            }
        }
        Product p =products.remove(products.size()-1);
        notifyAll();
        return p;
    }
}
