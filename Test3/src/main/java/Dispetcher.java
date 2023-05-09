public class Dispetcher extends Thread {

    private static Serviz serviz;

    public Dispetcher(Serviz serviz) {
        this.serviz = serviz;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = serviz.getRedyOrder();
                Thread.sleep(1000);

                serviz.addToFile(order);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

