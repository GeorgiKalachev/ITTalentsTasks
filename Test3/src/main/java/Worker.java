import java.time.LocalDateTime;

public class Worker extends Thread{

    private int id;
    private Zona zoneForWork;
    private int age;
    private Serviz serviz;

    public Worker(Serviz serviz,Zona zoneForWork, String name, int age) {
        this.zoneForWork = zoneForWork;
        setName(name);
        this.age = age;
        this.serviz = serviz;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        while (true){
           Order order = zoneForWork.take();
           //sleep for car getTime to repair
           Thread.sleep(serviz.getTimeForRepair());
           //redaktira koi q e naprawil
            order.setRepairedByID(this.id);
            order.setServicedAt(LocalDateTime.now());
            serviz.addReadyOrder(order);

        }
    }

    public int getAge() {
        return age;
    }
}
