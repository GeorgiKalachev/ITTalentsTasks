package TaskTest2.clients;

public class Adult extends Client{


    public Adult(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    @Override
    public double payAttraction(double price) {
       return price;
    }
}
