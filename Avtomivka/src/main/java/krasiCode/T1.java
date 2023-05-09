package krasiCode;

public class T1 extends Thread {

    Integer x;

    public T1(int x){
        this.x = x;
    }

    @Override
    public void run() {
        while(x < 100){
            //wait
        }
        //do smth
    }
}
