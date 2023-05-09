package krasiCode.blockingBob;

public class Demo {

    public static void main(String[] args) {

        Gurne g = new Gurne();

        new Thread(() -> {
            while (true){
                g.sipi();
            }
        }).start();

        new Thread(() -> {
            while(true){
                g.zemi();
            }
        }).start();

    }
}
