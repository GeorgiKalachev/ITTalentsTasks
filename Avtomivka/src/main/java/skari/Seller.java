package skari;

import skari.products.Product;

import java.util.List;

public class Seller extends Thread{

    public static Shop shop;

    public List<Product> collect(Product product, int quantity) {
        return shop.takeProduct(product, quantity);
    }

    @Override
    public void run() {
        super.run();
    }
}
