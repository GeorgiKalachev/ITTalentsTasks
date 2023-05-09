package skari;

import skari.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Product> products = new ArrayList();
    private int maxCapacity;

    public Container(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public synchronized void put(List<Product> products){
        try {
            while (this.products.size() > maxCapacity - products.size()){
                wait();
            }
            this.products.addAll(products);
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("ole male");
        }
    }

    public synchronized List<Product> take(int quantity){
        try {
            while (this.products.size() < quantity){
                wait();
            }
            List<Product> toBeGiven = new ArrayList<Product>();
            for (int i = 0; i < quantity; i++) {
                toBeGiven.add(this.products.remove(this.products.size()-1));
            }
            notifyAll();
            return toBeGiven;
        }
        catch (InterruptedException e){
            System.out.println("ole male");
            return new ArrayList<Product>();
        }
    }
}
