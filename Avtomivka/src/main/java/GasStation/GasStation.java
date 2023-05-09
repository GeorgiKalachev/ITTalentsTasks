package GasStation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GasStation {


    private int id;
    private String name;
    private List<Column> columns = new ArrayList<>();

    private List<Worker> workers;
    private List<Seller> seller;

    private List<Cashier> cashes = new ArrayList<>();

    public GasStation(String name) {
        this.name = name;
        this.workers = new ArrayList<>();
        this.seller = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            columns.add(new Column("Column " + i));
        }
        for (int i = 0; i < 2; i++) {
            workers.add(new Worker("Worker " + (i+1),this));
            workers.get(i).start();
        }
        for (int i = 0; i < 2; i++) {
            seller.add(new Seller("Seller " + (i+1),this));
            seller.get(i).start();
        }
        for (int i = 0; i < 2; i++) {
            cashes.add(new Cashier("Cash " + (i+1)));
        }
    }

    public synchronized List<Column> getColumns() {
        return columns;
    }

    public void start(){

    }

    public void servecedCarAtColumn(Column c) {


        Car car = c.getCars().peek();
        for (Cashier cas: cashes) {
            if(cas.isEmpty()){
                cas.putCar(car);
            }
        }


    }

    public synchronized List<Cashier> getCashes() {
        return cashes;
    }

    public void payedGasOnCashier(Column c) {


      //  DBManager.getInstance().saveOrder(c.getName(),c.cars.peek().getGas(),c.cars.peek().getLitresToLoad(),LocalDate.now());
       //
           // addToFile(c.getName(),c.cars.peek().getGas(),c.cars.peek().getLitresToLoad(),LocalDate.now());

        c.takeCar();


    }

    private void addToFile(String coumnName, String gas, double quantity , LocalDate dateServiced) {
        File f = new File(LocalDate.now()+".txt");
        try {
            if(!f.exists()){
                f.createNewFile();
            }
            String record = coumnName + "," +
                    gas + "," +
                    quantity + "," +
                    getPriceForGas(gas,quantity) + ","+
                    LocalDateTime.now()+"\n";
            Files.writeString(f.toPath(), record, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("ulala");
        }
    }

    private double getPriceForGas(String gas, double quantity) {

        switch (gas){
            case "GAS" -> {
                return quantity*1.60;
            }
            case "DISEL" -> {
                return quantity*2.40;
            }
            default -> {
                return quantity*2;
            }
        }


    }

}
