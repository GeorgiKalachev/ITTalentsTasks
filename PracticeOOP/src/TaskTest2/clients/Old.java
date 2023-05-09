package TaskTest2.clients;

public class Old extends Client{


    public Old(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    @Override
    public double payAttraction(double price) {
        return price * 0.80;
    }

}
