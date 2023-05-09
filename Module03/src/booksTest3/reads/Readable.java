package booksTest3.reads;

import java.time.LocalDate;
import java.util.Random;

public abstract class Readable implements Comparable<Readable> {
    public enum TYPE {
        BOOK,MAGAZINE,SCHOOLBOOK;
        public static TYPE[] getTypes() {
            return values();
        }
    }

    private String name;
    private LocalDate datePublished;
    private String izdatelstvo;
    private int id;
    private TYPE type;

    protected double pricePerRent;
    protected int maxRentDuration;
    protected double priceToPay;
    private Checker checker;

    public static int uniqId = 1;

    public Readable(String name, LocalDate datePublished, String izdatelstvo,TYPE type,double pricePerRent,int maxRentDuration) {
        this.name = name;
        this.datePublished = datePublished;
        this.izdatelstvo = izdatelstvo;
        this.id = uniqId++;
        this.type = type;
        this.pricePerRent = pricePerRent;
        this.maxRentDuration = maxRentDuration;
        this.priceToPay = pricePerRent;
    }


    private class Checker extends Thread{
        @Override
        public void run() {
            try {
                System.out.println(getName() + " Book is rent. Start waiting..");
                Thread.sleep(getMaxRentDuration()* 1000);
                System.out.println("Checker starts increasing price per second ..");
                while (true){
                    setPriceToPay();
                    System.out.println("Price increased to " + getPriceToPay());
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                System.out.println("lala i`m done");
                return;
            }
        }
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay() {
        this.priceToPay *= 1.05;
    }

    public int getMaxRentDuration() {
        return maxRentDuration;
    }

    public void rentBook(){
        checker = new Checker();
        checker.start();
    }

    public void returnBook(){
        checker.interrupt();
        double result = priceToPay;
        priceToPay = pricePerRent;
        System.out.println("Price to pay for : " + getName() + getType() + " --- : " + result);
    }
    public TYPE getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public String getIzdatelstvo() {
        return izdatelstvo;
    }

    protected Magazine.CATEGORY getCategory() {
        return null;
    };
    protected SchoolBook.THEME getTheme(){

        return null;
    };

    public void getInfo(){
        System.out.println(this.name + " : " +this.type);
    }
    @Override
    public int compareTo(Readable o) {
        return this.id - o.getId();
    }

    private int getId() {
        return this.id;
    }
}
