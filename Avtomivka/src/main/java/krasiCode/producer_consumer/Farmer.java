package krasiCode.producer_consumer;

public class Farmer extends Thread {

    private Storage storage;

    public Farmer(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        while(true){
            storage.putProduct(new Product("Cucumber"));
            try {
                Thread.sleep(1000);
                System.out.println("Added cucumber into the storage");
            } catch (InterruptedException e) {
                System.out.println("c c c biva li taka");
            }
        }
    }
}
