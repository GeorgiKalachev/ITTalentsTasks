package Skara.Gotvachi;

import Skara.Products.Product;
import Skara.SkaraFactory;

public class Baba extends Thread{

    private SkaraFactory skaraFactory;

    public Baba(SkaraFactory skaraFactory){
        this.skaraFactory = skaraFactory;
    }


    public Product collectBread(Product product) {
        return skaraFactory.takeBread(product);
    }

    public Product collectMeat(Product randomMeat) {
        return skaraFactory.takeMeat(randomMeat);
    }

    public Product collectSalad(Product randomSalad) {
        return skaraFactory.takeSalad(randomSalad);
    }
}
