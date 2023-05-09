package Pristanishte;

import java.util.LinkedList;

public class Dok {

    private LinkedList<Korab> korabi = new LinkedList<>();
    private Pristanishte pristanishte;

    public Dok(Pristanishte pristanishte){
        this.pristanishte = pristanishte;
    }



    public synchronized void put(Korab korab) {
        korabi.add(korab);
    }

    public boolean isEmpty(){
        return korabi.isEmpty();
    }
    public synchronized void svaliTovar(){
        try {
            Thread.sleep(korabi.getFirst().getTimeToTake());
            pristanishte.getSklad(korabi.getFirst());
            pristanishte.removeKorab(korabi.getFirst());
            System.out.println("svalihme tovar ot korab " + korabi.getFirst().getClass().getSimpleName() + " for " +korabi.getFirst().getTimeToTake() + " milsec");
            korabi.removeFirst();
        }catch (InterruptedException e){
            System.out.println("fack");
        }
    }
}
