package Pristanishte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pristanishte {


    private List<Dok> dokove = new ArrayList<>();

    private List<Kran> kranove = new ArrayList<>();

    private List<Sklad> skladove = new ArrayList<>();

    private List<Distributor> distributori = new ArrayList<>();

    private ArrayList<Korab> korabi = new ArrayList<>();

    public Pristanishte(){
        for (int i = 0; i < 5; i++) {
            dokove.add(new Dok(this));
        }
        for (int i = 0; i < 2; i++) {
            kranove.add(new Kran(this));
            kranove.get(i).start();
        }
        for (int i = 0; i < 2; i++) {
            skladove.add(new Sklad(this));
        }

        for (int i = 0; i < 2; i++) {
            distributori.add(new Distributor(this));
            distributori.get(i).start();
        }

    }

    public synchronized void addKorab(Korab korab){
        korabi.add(korab);
        System.out.println("Korab doide...");
        dokove.get(new Random().nextInt(dokove.size()-1)).put(korab);
        notifyAll();
    }

    public synchronized void checkingForShips(){
        try {
            while (korabi.isEmpty()) {
                wait();
            }

        }catch (InterruptedException e){
            System.out.println("ok");
        }
    }

    public synchronized void getSklad(Korab first) {

        skladove.get(new Random().nextInt(2)).putPratki(first);
        notifyAll();
    }

    public synchronized void checkForPratki() {

        try {
            while (skladove.get(0).isEmpty() && skladove.get(1).isEmpty()){
                wait();
            }

        }catch (InterruptedException e){
            System.out.println("ok");
        }
    }

    public void removeKorab(Korab first) {
        korabi.remove(first);
    }

    public Dok getDokWithShips() {
        for (Dok dok : dokove){
            if (!dok.isEmpty()){
                return dok;
            }
        }
        return null;
    }

    public Sklad getSkladWithpackadjes() {
        for (Sklad sklad : skladove){
            if (!sklad.isEmpty()){
                return sklad;
            }
        }
        return null;
    }
}
