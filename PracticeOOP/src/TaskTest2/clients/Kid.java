package TaskTest2.clients;

public class Kid extends Client{


    public Kid(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    @Override
    public double payAttraction(double price) {
        return price / 2;
    }
}
