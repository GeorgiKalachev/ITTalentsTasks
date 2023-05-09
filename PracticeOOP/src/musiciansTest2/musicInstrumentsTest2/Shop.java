package musiciansTest2.musicInstrumentsTest2;

import musiciansTest2.Util;
import musiciansTest2.musicInstrumentsTest2.instruments.*;

import java.util.*;

public class Shop {


    private double money;
    private Map<Instrument.InstrType, Map<String, Set<Instrument>>> storage = new HashMap<>();

    public void addInstrumen(Instrument instrument) {

        // check if type is there
        if (!storage.containsKey(instrument.getType())) {
            storage.put(instrument.getType(), new HashMap<>());
        }

        // check if kind is there
        if (!storage.get(instrument.getType()).containsKey(instrument.getKind())) {
            storage.get(instrument.getType()).put(instrument.getKind(), new HashSet<>());
        }

        storage.get(instrument.getType()).get(instrument.getKind()).add(instrument);
        System.out.println(instrument.getKind() + " with name " + instrument.getName()
                + " for : " + instrument.getPrice() + ", added to storage.");

    }

    public void getInstrumentsForSale(String kind, int amount){
        for (Map.Entry<Instrument.InstrType, Map<String, Set<Instrument>>> e : storage.entrySet()) {


                for (int i = 0; i < amount; i++) {
                    Instrument instrument;
                    switch (e.getKey()){
                        case DUHOVI -> instrument = new Duhov(Util.getRandomName(),
                                new Random().nextDouble(50,200),kind);
                        case ELEKTRONNI -> instrument = new Elektronen(Util.getRandomName(),
                                new Random().nextDouble(50,200),kind);
                        case STRUNNI -> instrument = new Strunen(Util.getRandomName(),
                                new Random().nextDouble(50,200),kind);
                        case KLAVISHNI -> instrument = new Klavishen(Util.getRandomName(),
                                new Random().nextDouble(50,200),kind);
                        default ->   instrument = new Udaren(Util.getRandomName(),
                                new Random().nextDouble(50,200),kind);
                    }
                    addInstrumen(instrument);
                }


        }

    }

    public void sellInstruments(String kind,int amount){
        for (Map.Entry<Instrument.InstrType, Map<String, Set<Instrument>>> e : storage.entrySet()) {

            if (storage.get(e.getKey()).containsKey(kind)){
                if (storage.get(e.getKey()).get(kind).size() < amount){
                    System.out.println("not enought product");
                    return;
                }
                double worth = 0;

                for (int i = 0; i < amount; i++) {
                    Optional<Instrument> instrument = storage.get(e.getKey()).get(kind).stream().findAny();
                    if(instrument.isPresent()) {
                        worth += instrument.get().getPrice();
                        storage.get(e.getKey()).get(kind).remove(instrument.get());
                    }
                }
                this.money += worth;
                System.out.println(amount + kind + " selled for : " + worth);


            }



        }
    }

    public void printAll() {
        for (Map.Entry<Instrument.InstrType, Map<String, Set<Instrument>>> e : storage.entrySet()) {
            System.out.println(e.getKey() + ":");
            Map<String, Set<Instrument>> instrumentsByClass = e.getValue();
            for (Map.Entry<String, Set<Instrument>> e1 : instrumentsByClass.entrySet()) {
                System.out.println("\t" + e1.getKey() + ":");
                Set<Instrument> instrumentsByType = e1.getValue();
                for (Instrument instrument : instrumentsByType) {
                    System.out.println(instrument.getName() + " ," + instrument.getPrice() + " lv. ");
                }
            }
        }
    }


    public void printCatalogByType(){





    }
}
