package Pristanishte;

public class Kran extends Thread{

    private Pristanishte pristanishte;

    public Kran(Pristanishte pristanishte){
        this.pristanishte = pristanishte;
    }

    @Override
    public void run() {
        while (true){
            pristanishte.checkingForShips();
            Dok dok = pristanishte.getDokWithShips();
            if(dok != null){

                dok.svaliTovar();

            }
        }
    }
}
