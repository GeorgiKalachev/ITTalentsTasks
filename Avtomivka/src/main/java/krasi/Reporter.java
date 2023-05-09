package krasi;
public class Reporter extends Thread{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000*60*60*24);
                stat1();
                stat2();
                stat3();
                stat4();
                stat5();
            } catch (InterruptedException e) {
                System.out.println("ole male");
            }
        }
    }

    private void stat1() {
        DBManager.getInstance().totalServicedFor24h();
    }
    private void stat2() {
        DBManager.getInstance().totalWorkersWith3OrMoreServiced();
    }
    private void stat3() {
        DBManager.getInstance().mostWantedServiceFor24h();
    }
    private void stat4() {
        DBManager.getInstance().mostCommonVType();
    }
    private void stat5() {
        DBManager.getInstance().youngestThatWorkedHardWithTrucks();
    }
}
