package krasiCode;

public class T2 extends Thread {

    Integer x;

    public T2(Integer x){
        this.x = x;
    }

    @Override
    public void run() {
        x++;
    }
}
