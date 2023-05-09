package krasiCode.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Product> products = new ArrayList();
    private static final int MAX_CAPACITY = 10;

    public synchronized void putProduct(Product p){
        while (products.size() >= MAX_CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ujas");
            }
        }
        products.add(p);
        notifyAll();
    }

    public synchronized Product takeProduct(){
        while (products.size() <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("navik!");
            }
        }
        Product p = products.remove(products.size()-1);
        notifyAll();
        return p;
    }
}