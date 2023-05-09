import java.time.LocalDateTime;
import java.util.Random;

public class Diagnostic extends Thread{

    private int id;
    private int age;
    private Serviz serviz;

    public Diagnostic(String name,int age, Serviz serviz) {
        setName(name);
        this.age = age;
        this.serviz = serviz;
    }


    @Override
    public void run() {
        try {
            while (true) {

                Order order = serviz.getCarForDiagnostic();

                Thread.sleep(5000);
                // decide what diagnostic

                if (new Random().nextBoolean()){
                    order.setDiagnosticAt(LocalDateTime.now());
                    order.setDiagnostedByID(this.id);
                    serviz.getZone().put(order);
                }



            }
        }catch (InterruptedException e){
            System.out.println("ok");
        }
    }

    public int getAge() {
        return age;
    }

    public void setId(int anInt) {
        this.id = anInt;
    }
}
