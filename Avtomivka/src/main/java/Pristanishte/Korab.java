package Pristanishte;

public class Korab {

    private int bagaj;

    public Korab(int bagaj){
        this.bagaj = bagaj;
    }
    public long getTimeToTake() {
        return bagaj * 2000L;
    }
}
