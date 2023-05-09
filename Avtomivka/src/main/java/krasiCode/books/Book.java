package krasiCode.books;

public class Book {

    private double pricePerRent = 2;
    private int maxRentDuration = 3;
    private double priceToPay = pricePerRent;
    private Checker checker;

    private class Checker extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("Checker started! We wait and see!");
                Thread.sleep(maxRentDuration*1000);
                System.out.println("Checker starts increasing price!");
                while (true){
                    priceToPay *= 1.05;
                    System.out.println("Price increased to " + priceToPay);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                System.out.println("lala i`m done");
                return;
            }
        }
    }

    public void rentBook(){
        checker = new Checker();
        checker.start();
    }

    public double returnBook(){
        checker.interrupt();
        double result = priceToPay;
        priceToPay = pricePerRent;
        return result;
    }

}
