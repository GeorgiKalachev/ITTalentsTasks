package GasStation;

public class Seller extends Thread{

    private int id;
    private String name;
    private GasStation station;
    private Cashier cash = null;

    public Seller(String name, GasStation station) {
        this.name = name;
        this.station = station;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void run() {
        try {
            while (true) {
                for (Cashier c : station.getCashes()) {
                    if (c.getCars().isEmpty()) {
                        cash = c;
                        System.out.println(name + " is servecing TO PAY  " + c.getName());

                        Thread.sleep(5000); // pay order

                        station.payedGasOnCashier(c.getCar().getColumn());
                        cash.takeCar();
                        cash = null;

                        break;
                    }
                }

            }
        }catch (InterruptedException e){
            System.out.println("opa");
        }
    }
}
