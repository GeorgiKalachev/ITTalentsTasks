package Skara;

public class Demo {

    public static void main(String[] args) {


        SkaraFactory skara = new SkaraFactory();

        for (int i = 0; i < 3; i++) {
            Client client = new Client(skara);
            client.start();
        }




    }
}
