package GasStation;

public class Worker extends Thread{

    private int id;
    private String name;
    private GasStation station;
    private Column column = null;

    public Worker( String name,GasStation station) {
        this.name = name;
        this.station = station;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                while (true) {
                    boolean carServiced = false;
                    for (Column c : station.getColumns()) {
                        if (!c.isEmpty() && c.getServicedBy() == null) {
                            synchronized(c) {
                                if (c.getServicedBy() == null) {
                                    carServiced = true;
                                    c.setServicedBy(this);
                                    System.out.println(name + " is servicing car at " + c.getName());
                                    Thread.sleep(5000); // fill gas for 5 seconds
                                    c.setServicedBy(null);
                                    station.servecedCarAtColumn(c);
                                    break;
                                }
                            }
                        }
                    }

                    if (!carServiced) {
                        wait(); // wait for a car to arrive
                    }
                }

            }
        }catch (InterruptedException e){
            System.out.println("opa");
        }
    }
}
