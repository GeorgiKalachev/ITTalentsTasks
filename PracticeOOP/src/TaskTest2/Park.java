package TaskTest2;

import TaskTest2.attractions.Atraction;
import TaskTest2.attractions.Extreme;
import TaskTest2.attractions.Normal;
import TaskTest2.beasts.*;
import TaskTest2.clients.Adult;
import TaskTest2.clients.Client;
import TaskTest2.clients.Kid;
import TaskTest2.clients.Old;

import java.util.*;

public class Park {

    private String name;
    private String addres;
    private double cashMoney = 0;

    private Set<Normal> normalAttractions = new HashSet<>();
    private Set<Extreme> extremeAttraction = new HashSet<>();
    private Set<Client> clients = new HashSet<>();

    private Map<Beast.BeastType,Map<String,Double>> catalog;

    public Park(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    private void addBeastToCatalog(Beast beast){

        if (!catalog.containsKey(beast.getType())) {
            catalog.put(beast.getType(), new HashMap<>());
        }

        if (!catalog.get(beast.getType()).containsKey(beast.getName())) {
            catalog.get(beast.getType()).put( beast.getName(), beast.getPrice());
        }

        catalog.get(beast.getType()).put(beast.getName(),beast.getPrice());

    }
    public void addNormalAttractions(){

        Normal atraction;
        Beast beast;
        for (int i = 0; i < 3; i++) {
            beast = new Kraken("Kraken" + i);
            atraction = new Normal("normal " + i,beast);
            this.normalAttractions.add(atraction);
           // addBeastToCatalog(beast);
        }
        for (int i = 0; i < 3; i++) {
            beast = new Griffon("Griffon" + i);
            atraction = new Normal("normal " + (i+3),beast);
            this.normalAttractions.add(atraction);
         //   addBeastToCatalog(beast);
        }
        for (int i = 0; i < 3; i++) {
            beast = new Dwarf("Dwarf" + i);
            atraction = new Normal("normal " + (i+6),beast);
            this.normalAttractions.add(atraction);
          //  addBeastToCatalog(beast);
        }

    }
    public void addExtremeAttractions(){

        Extreme atraction;
        Beast beast;
        for (int i = 0; i < 2; i++) {
            beast = new Rusalka("Rusalka" + i);
            atraction = new Extreme("extreme " + i,beast);
            this.extremeAttraction.add(atraction);
            //addBeastToCatalog(beast);
        }
        for (int i = 0; i < 2; i++) {
            beast = new Dragon("Dragon" + i);
            atraction = new Extreme("extreme " + (i+2),beast);
            this.extremeAttraction.add(atraction);
            //addBeastToCatalog(beast);
        }
        for (int i = 0; i < 3; i++) {
            beast = new Dwarf("Dwarf" + i);
            atraction = new Extreme("extreme " + (i+4),beast);
            this.extremeAttraction.add(atraction);
           // addBeastToCatalog(beast);
        }
    }

    public void addClients(){

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Client client;
            int chance = r.nextInt(3);
            switch (chance){
                case 0 -> client = new Kid(Util.getRandomName(),r.nextInt(4,18),r.nextBoolean());
                case 1 -> client = new Adult(Util.getRandomName(),r.nextInt(18,50),r.nextBoolean());
                default -> client = new Old(Util.getRandomName(),r.nextInt(50,80),r.nextBoolean());
            }
            this.clients.add(client);
        }
    }

    public void clientsEnterAttraction(){

        for (int i = 0; i < 2; i++) {
            for (Client client: this.clients) {
                if(client instanceof Kid){
                    normalAttractions.stream().findAny().get().addingClients(client);
                }

                if(new Random().nextBoolean()){
                    extremeAttraction.stream().findAny().get().addingClients(client);
                }else {
                    normalAttractions.stream().findAny().get().addingClients(client);
                }
            }
        }




    }

    public void startAttractions(){

        for (Atraction atraction : this.normalAttractions) {
            atraction.beastEnterteinClients();
        }
        for (Atraction atraction : this.extremeAttraction) {
            atraction.beastEnterteinClients();
        }

        for (Atraction atraction : this.normalAttractions) {
            this.cashMoney += atraction.getMoney();
        }
        for (Atraction atraction : this.extremeAttraction) {
            this.cashMoney += atraction.getMoney();
        }
    }
    
    
    public void statistics(){
        stats1();
        stats2();
        stats3();
        stats4();
        stats5();
        
        
    }

    private void stats5() {
        //Справка с всички типове животни, подредени по акумулираните приходи.
         Map<Beast.BeastType,Map<String,Double>> ranglist = new HashMap<>();

        for (Normal cage:this.normalAttractions) {
            if(!ranglist.containsKey(cage.getBeast().getType())){
                ranglist.put(cage.getBeast().getType(),new HashMap<>());
            }
            if(!ranglist.get(cage.getBeast().getType()).containsKey(cage.getBeast().getName())){
                ranglist.get(cage.getBeast().getType()).put(cage.getBeast().getName(),cage.getMoney() );
            }
        }
        for (Extreme cage:this.extremeAttraction) {
            if(!ranglist.containsKey(cage.getBeast().getType())){
                ranglist.put(cage.getBeast().getType(),new HashMap<>());
            }
            if(!ranglist.get(cage.getBeast().getType()).containsKey(cage.getBeast().getName())){
                ranglist.get(cage.getBeast().getType()).put(cage.getBeast().getName(),cage.getMoney() );
            }
        }


        for (Map.Entry<Beast.BeastType,Map<String,Double>> e : ranglist.entrySet()) {
            System.out.println(e.getKey() + " : ");

            Map<String,Double> byBeast = e.getValue();
            for (Map.Entry<String,Double> b: byBeast.entrySet()) {
                System.out.println(b.getKey() + b.getValue() );
            }
        }

    }

    private void stats4() {

        System.out.println("stats 4");
        long count = clients.stream().filter(o -> !o.isAlive()).count();
        System.out.println("Killed clients are : " + count);
    }

    private void stats3() {
        System.out.println("stats 3");

    }

    private void stats2() {
        System.out.println("stats 2");
        System.out.println("Money from the attractions : " + this.cashMoney);
    }

    private void stats1() {

        System.out.println("stats 1");
        int kids = 0;
        for (Client client: this.clients) {
            if ( client instanceof Kid){
                kids++;
            }
        }

        System.out.println("Kids in the park are : " + kids);
    }


}
