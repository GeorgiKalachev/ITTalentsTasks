package GasStation;

public class Demo {

    public static void main(String[] args) {

        GasStation station = new GasStation("Krasi");

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(4000);
                Car car = new Car("Car "+ (i+1),station);
                for (Column c: station.getColumns()) {
                    if(c.isEmpty()){
                        c.putCar(car);
                        System.out.println(car.getName() + " going on " + c.getName());
                    }
                }
            }catch (InterruptedException e){
                System.out.println("ops");
            }
        }

    }
}