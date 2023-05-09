package Skara;

import Skara.Gotvachi.Baba;
import Skara.Gotvachi.HlebarGotvach;
import Skara.Gotvachi.MeatGotvach;
import Skara.Gotvachi.SaladGotvach;
import Skara.Products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkaraFactory {

    private List<Product> breads = new ArrayList<>();
    private List<Product> meats = new ArrayList<>();
    private List<Product> salads = new ArrayList<>();
    private MeatGotvach mesar;
    private SaladGotvach zagotovki;
    private HlebarGotvach hlebar;
    private Baba baba;
    private double totalIncome = 0;

    public SkaraFactory(){
        this.mesar = new MeatGotvach(this);
        mesar.start();
        this.zagotovki = new SaladGotvach(this);
        zagotovki.start();
        this.hlebar = new HlebarGotvach(this);
        hlebar.start();
        this.baba = new Baba(this);
        baba.start();
    }

    public void takeOrder(Product randomBread, Product randomMeat, Product randomSalad) {
        System.out.println("Client " + Thread.currentThread().getName() + " ORDERS " + randomBread.getClass().getSimpleName() + ", " + randomMeat.getClass().getSimpleName() + ", " + randomSalad.getClass().getSimpleName());
        Product bread   = baba.collectBread(randomBread);
        Product meat    = baba.collectMeat(randomMeat);
        Product salad   = baba.collectSalad(randomSalad);
        double price = bread.getPrice() + meat.getPrice() + salad.getPrice();
        totalIncome += price;
        System.out.println("CLIENT " + Thread.currentThread().getName() + " HAS ITS ORDER COMPLETED");
    }

    public void putBread(Product product) {
        synchronized (breads) {
            while (breads.size() > 30){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("ops");
                }
            }
            breads.add(product);
            breads.notifyAll(); // wake up any waiting threads
        }
    }

    public void putSalad(Product product) {
        synchronized (salads) {
            while (salads.size() > 50){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("ops");
                }
            }
            salads.add(product);
            salads.notifyAll(); // wake up any waiting threads
        }
    }

    public void putMeat(Product product) {
        synchronized (meats) {
            while (meats.size() > 20){
                try {
                    meats.wait();
                } catch (InterruptedException e) {
                    System.out.println("ops");
                }
            }
            meats.add(product);
            meats.notifyAll(); // wake up any waiting threads
        }
    }

    public Product takeBread(Product product) {
        while (true) {
            synchronized (breads) {
                Optional<Product> optionalProduct = breads.stream()
                        .filter(b -> b.getProductType().equals(product.getProductType()))
                        .findFirst();
                if (optionalProduct.isPresent()) {
                    breads.remove(optionalProduct.get());
                    breads.notifyAll(); // wake up any waiting threads
                    return optionalProduct.get();
                }
            }
        }
    }

    public Product takeMeat(Product product) {
        while (true) {
            synchronized (meats) {
                Optional<Product> optionalProduct = meats.stream()
                        .filter(b -> b.getProductType().equals(product.getProductType()))
                        .findFirst();
                if (optionalProduct.isPresent()) {
                    meats.remove(optionalProduct.get());
                    meats.notifyAll(); // wake up any waiting threads
                    return optionalProduct.get();
                }
            }
        }
    }

    public Product takeSalad(Product product) {
        while (true) {
            synchronized (salads) {
                Optional<Product> optionalProduct = salads.stream()
                        .filter(b -> b.getProductType().equals(product.getProductType()))
                        .findFirst();
                if (optionalProduct.isPresent()) {
                    salads.remove(optionalProduct.get());
                    salads.notifyAll(); // wake up any waiting threads
                    return optionalProduct.get();
                }
            }
        }
    }
}
