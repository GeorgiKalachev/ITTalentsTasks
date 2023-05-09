package skari;

import skari.products.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private int id = 9;
    private Seller seller;
    private BreadCook breadCook;
    private MeatCook meatCook;
    private SaladCook saladCook;
    private Map<String, Container> bowls;
    private double totalIncome = 0;

    public Shop(){
        seller = new Seller();
        breadCook = new BreadCook();
        meatCook = new MeatCook();
        saladCook = new SaladCook();
        bowls = new HashMap();
        bowls.put(BqlHlqb.class.getName(), new Container(30));
        bowls.put(PulnozurnestHlqb.class.getName(), new Container(30));

        bowls.put(Purjola.class.getName(), new Container(20));
        bowls.put(Pleskavica.class.getName(), new Container(20));
        bowls.put(Kiufte.class.getName(), new Container(20));

        bowls.put(Snejanka.class.getName(), new Container(5000));
        bowls.put(RuskaSalata.class.getName(), new Container(5000));
        bowls.put(ZeleMorkovi.class.getName(), new Container(5000));
        bowls.put(DomatiKrastavici.class.getName(), new Container(5000));
        bowls.put(Liutenica.class.getName(), new Container(5000));

    }

    public void order(Product randomBread, Product randomMeat, Product randomSalad) {
        System.out.println("CLIENT " + Thread.currentThread().getName() + " ORDERS " + randomBread.getClass().getSimpleName() + ", " + randomMeat.getClass().getSimpleName() + ", " + randomSalad.getClass().getSimpleName());
        Product bread   = seller.collect(randomBread, 1).get(0);
        Product meat    = seller.collect(randomMeat, 1).get(0);
        Product salad   = seller.collect(randomSalad, 1).get(0);
        double price = bread.getPrice() + meat.getPrice() + salad.getPrice();
        totalIncome += price;
        System.out.println("CLIENT " + Thread.currentThread().getName() + " HAS ITS ORDER COMPLETED");
        addToFile(bread, meat, salad);
    }

    private void addToFile(Product bread, Product meat, Product salad) {
        File f = new File(LocalDate.now().toString()+".txt");
        try {
            if(!f.exists()){
                f.createNewFile();
            }
            String record = bread.getClass().getSimpleName() + "," +
                    meat.getClass().getSimpleName() + "," +
                    salad.getClass().getSimpleName() + "," +
                    (bread.getPrice() + meat.getPrice() + salad.getPrice()) + ","+
                    LocalDateTime.now()+"\n";
            Files.writeString(f.toPath(), record, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("ulala");
        }
    }

    public List<Product> takeProduct(Product product, int quantity) {
        return bowls.get(product.getClass().getName()).take(quantity);
    }

    public void add(List<Product> products) {
        bowls.get(products.get(0).getClass().getName()).put(products);
    }

    public void open() {
        seller.start();
        meatCook.start();
        saladCook.start();
        breadCook.start();
        Reporter reporter = new Reporter();
        reporter.setDaemon(true);
        reporter.start();
    }

    public int getId() {
        return id;
    }
}
