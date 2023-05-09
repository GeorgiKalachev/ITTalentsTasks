package krasiCode;

public class VolatileDemo {

    static volatile Integer x = 100;

    public static void main(String[] args) {
        new T1(x).start();
        new T2(x).start();
    }
}
