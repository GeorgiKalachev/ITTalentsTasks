package Lutenica.people;

import Lutenica.Fabric;
import Lutenica.products.Product;

public class Momcheta extends Thread{

    private int id;
    private Fabric fabric;
    private int age;
    private String name;

    public Momcheta(String name,int age,Fabric fabric){
        setName(name);
        this.age = age;
        this.fabric = fabric;
    }

    @Override
    public void run() {
        while (true){
            Product product = fabric.getProductToCook();
            try {
                Thread.sleep(product.getTimeToCook()*1000);
                System.out.println(Thread.currentThread().getName() + " obrabotva " +product.getName()+ " za : " +product.getTimeToCook());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fabric.putProductForCOOK(product);
        }
    }
}
