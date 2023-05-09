package Lutenica;

import Lutenica.people.Babi;
import Lutenica.people.Momcheta;
import Lutenica.people.Momi;
import Lutenica.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fabric {


    private ArrayList<Product> domatiKosh = new ArrayList<>(40);
    private ArrayList<Product> chushkaKosh = new ArrayList<>(40);
    private ArrayList<Product> patladjanKosh = new ArrayList<>(40);
    private ArrayList<Product> gotoviDomati = new ArrayList<>(30);
    private ArrayList<Product> gotoviChushki = new ArrayList<>(30);
    private ArrayList<Product> gotoviPatladjani = new ArrayList<>(30);

    private List<Momi> momite = new ArrayList<>();
    private List<Momcheta> momcheta = new ArrayList<>();
    private List<Babi> babite = new ArrayList<>();


    public Fabric(){
        for (int i = 0; i < 5; i++) {
            momite.add(new Momi("Moma " + i,new Random().nextInt(14,20),this));
            momite.get(i).start();
            momcheta.add(new Momcheta("Momche " + i,new Random().nextInt(20,40),this));
            momcheta.get(i).start();
        }
        for (int i = 0; i < 3; i++) {
            babite.add(new Babi("Baba " + i,new Random().nextInt(60,120),this));
            babite.get(i).start();
        }

    }

    public synchronized void madeProduct(Product product,int quantity){
        try {

            for (int i = 0; i < quantity; i++) {
                switch (product.getName()) {
                    case "Domat" -> {
                        while (domatiKosh.size() >= 30) {
                            wait();
                        }
                        domatiKosh.add(product);
                    }
                    case "Patladjan" -> {
                        while (patladjanKosh.size() >= 30){
                            wait();
                        }
                        patladjanKosh.add(product);
                    }
                    default -> {
                        while(chushkaKosh.size() >= 30){
                            wait();
                        }
                        chushkaKosh.add(product);
                    }
                }
                notifyAll();
            }
            System.out.println(product.getName() + " added : " + quantity);
        }catch (InterruptedException p){
            System.out.println("ops");
        }

    }

    public synchronized Product getProductToCook(){
        Product product = null;
        try {
            int chance = new Random().nextInt(3);
            switch (chance) {
                case 1 -> {
                    while(domatiKosh.size() == 0){
                        wait();
                    }
                    product = domatiKosh.get(domatiKosh.size()-1);
                }
                case 2 -> {
                    while(patladjanKosh.size() == 0){
                        wait();
                    }
                    product = patladjanKosh.get(patladjanKosh.size()-1);
                }
                default -> {
                    while (chushkaKosh.size() == 0){
                        wait();
                    }
                    product = chushkaKosh.get(chushkaKosh.size()-1);
                }
            }
        }catch (InterruptedException e){
            System.out.println("moje");
        }
        notifyAll();
        System.out.println("Product taken from " + Thread.currentThread().getName() + " -- " + product.getName());
        return product;
    }

    public synchronized void putProductForCOOK(Product product) {

        try {
            switch (product.getName()) {
                case "Domat" -> {
                    while (gotoviDomati.size() >= 30) {
                        wait();
                    }
                    gotoviDomati.add(product);
                }
                case "Patladjan" -> {
                    while (gotoviPatladjani.size() >= 30){
                        wait();
                    }
                    gotoviPatladjani.add(product);
                }
                default -> {
                    while (gotoviChushki.size() >= 30){
                        wait();
                    }
                    gotoviChushki.add(product);
                }
            }
            System.out.println(product.getName() + " is READY to be cooked ");

            notifyAll();
        }catch (InterruptedException e){
            System.out.println("ok");
        }
    }

    public synchronized void makeLutenica() {
        try {
            while (gotoviDomati.size() < 5 && gotoviPatladjani.size() < 5 && gotoviChushki.size() < 5){
                wait();
                System.out.println(Thread.currentThread().getName() + " waiting to make Lutenica.");
            }
                for (int i = 0; i < 5; i++) {
                    gotoviDomati.get(gotoviDomati.size()-1);
                gotoviPatladjani.get(gotoviPatladjani.size()-1);
                gotoviChushki.get(gotoviChushki.size()-1);
                notifyAll();
               }
            System.out.println(Thread.currentThread().getName() + " napravi lutenica : "
            + gotoviDomati.size() +" domati ostavat "
            + gotoviPatladjani.size() +" patladjani ostavat "
            + gotoviChushki.size() +" chushki ostavat ");
        }catch (InterruptedException e){
            System.out.println("moje");
        }

    }
}
