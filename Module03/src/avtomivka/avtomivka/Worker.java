package avtomivka;

import java.util.Objects;

public class Worker extends Thread{

    public static CarWash carWash;
    private int id;
    private int age;

    public Worker(String name, int age){
        setName(name);
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while(true){

            try{
                VehicleOrder vo = carWash.getNextOrder();
                switch (vo.getService().getName()) {
                    case INNER -> {
                        carWash.getInner().put();
                        Thread.sleep(carWash.getWashTime(vo.getService().getName(), vo.getVehicleType().getName()));
                        carWash.getInner().take();
                    }
                    case OUTER -> {
                        carWash.getOuter().put();
                        Thread.sleep(carWash.getWashTime(vo.getService().getName(), vo.getVehicleType().getName()));
                        carWash.getOuter().take();
                    }
                    case COMBINED -> {
                        carWash.getInner().put();
                        Thread.sleep(carWash.getWashTime(Service.ServiceName.INNER, vo.getVehicleType().getName()));
                        carWash.getInner().take();
                        carWash.getOuter().put();
                        Thread.sleep(carWash.getWashTime(Service.ServiceName.OUTER, vo.getVehicleType().getName()));
                        carWash.getOuter().take();
                    }
                    default -> throw new UnsupportedOperationException("Ai siktir");
                }
                System.out.println(Thread.currentThread().getName() + " - order done");
                DBManager.getInstance().updateOrder(vo, this);
            }
            catch (InterruptedException e){
                System.out.println("jesus fking christ");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id && age == worker.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age);
    }
}
