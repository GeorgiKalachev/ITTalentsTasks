package Pristanishte;

public class Distributor extends Thread{

    private Pristanishte pristanishte;


    public Distributor(Pristanishte pristanishte){
        this.pristanishte = pristanishte;
    }

    @Override
    public void run() {
        try {

            while (true) {
                pristanishte.checkForPratki();
                Sklad sklad = pristanishte.getSkladWithpackadjes();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " svali pratka za 5 sek");
                sklad.removePratka();
            }
        }catch (InterruptedException e){
            System.out.println("oh");
        }
    }
}
