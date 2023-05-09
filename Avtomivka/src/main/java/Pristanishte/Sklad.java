package Pristanishte;

import java.util.LinkedList;

public class Sklad {

    private LinkedList<Pratka> pratki = new LinkedList<>();

    private Pristanishte pristanishte;

    public Sklad(Pristanishte pristanishte){
        this.pristanishte = pristanishte;
    }


    public synchronized void putPratki(Korab first) {
        for (int i = 0; i < first.getTimeToTake()/1000/2; i++) {
            pratki.add(new Pratka());
        }
    }
    public boolean isEmpty(){
        return pratki.isEmpty();
    }

    public synchronized void removePratka() {
        pratki.removeFirst();
    }
}
