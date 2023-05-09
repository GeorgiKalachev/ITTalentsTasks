package Skara;

import Skara.Products.Product;

public class Client extends Thread{

    private SkaraFactory skara;

    public Client (SkaraFactory skara){
        this.skara = skara;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            skara.takeOrder(Product.getRandomBread(), Product.getRandomMeat(), Product.getRandomSalad());
        }catch (InterruptedException e){
            System.out.println("ok");
        }
    }
}
