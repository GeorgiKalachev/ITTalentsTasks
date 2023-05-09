package musiciansTest2.cakesTest2.cakes;

import musiciansTest2.Util;
import musiciansTest2.cakesTest2.cakes.*;
import musiciansTest2.cakesTest2.cakes.persons.Client;
import musiciansTest2.cakesTest2.cakes.persons.Deliver;

import java.util.*;

public class SweetShop {

    private String name;
    private String addres;
    private String phoneNum;

    private Set<Client> clients;
    private Set<Deliver> delivers;
    private Set<Cake> cakes;
    private Map<CakeType, Map<String,Integer>> catalog;

    public static int cakeID = 1;
    private double money;
    private CakeType cakeOfDay;



    public SweetShop(String name, String addres, String phoneNum) {
        this.name = name;
        this.addres = addres;
        this.phoneNum = phoneNum;
        this.delivers = new HashSet<>();
        this.catalog = new HashMap<>();
        this.clients = new HashSet<>();
        this.cakes = new HashSet<>();
    }

    public void payOrder(double money){
        this.money += money;
    }

    public void amountOfProfit(){
        System.out.println(this.money + " for today.");
    }
    public void hiringFiveDelivers(){
        for (int i = 0; i < 5; i++) {
            this.delivers.add( new Deliver(Util.getRandomName(),Util.getRandomPhone()));
        }
    }

    public void makingCakes(){
        Random r = new Random();
        Cake cake = null;
        for (int i = 0; i < 30; i++) {
            int chance = r.nextInt(4);
            switch (chance){
                case 0 -> cake = new StandartCake(r.nextInt(20,40), r.nextInt(6,18) );
                case 1 -> cake = new WeddingCake(r.nextInt(50,200), r.nextInt(20,50) );
                case 2 -> cake = new Special(r.nextInt(30,100), r.nextInt(6,18) );
                case 3 -> cake = new KidsCake(r.nextInt(40,140), r.nextInt(10,20) );
            }
            this.cakes.add(cake);
        }
    }

    public void makingClients() {
        for (int i = 0; i < 10; i++) {
            clients.add(new Client("client : " + Util.getRandomName(),Util.getRandomPhone(), Util.getRandomAdress()));
        }
    }

    public void clientMakingOrders() {

        for (Client client : clients) {
            client.makeOrder(this);
        }
    }

    public Deliver getRandomDeliver() {

        return delivers.stream().skip(new Random().nextInt(delivers.size())).findFirst().orElse(null);

    }



    /*
     this.rankings.put(ArcherType.JUNIOR, new HashMap<>());
        this.rankings.put(ArcherType.SENIOR, new HashMap<>());
        this.rankings.put(ArcherType.VETERAN, new HashMap<>());

        List<Archer> participants = new ArrayList(this.archers);
        System.out.println("TOURNAMENT STARTS, LIST OF PARTICIPANTS:");
        participants.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        participants.stream()
                .peek(p -> p.incrementTournament())
                .peek(p -> System.out.println(p.getName()))
                .forEach(p -> {
                    int totalPoints = p.shoot();
                    rankings.get(p.getType()).put(p.getName(), totalPoints);
                });
        System.out.println("RANKINGS!");
     */
    public void viewTheMenu() {
        this.catalog.put(CakeType.SPECIAL,new HashMap<>());
        this.catalog.put(CakeType.KIDSTYPE,new HashMap<>());
        this.catalog.put(CakeType.WEDDING,new HashMap<>());
        this.catalog.put(CakeType.STANDART,new HashMap<>());
        System.out.println("Shop starts with these Cakes : ");
        List<Cake> cakes = new ArrayList<>(this.cakes);

        cakes.sort((o1, o2) ->  o1.getName().compareTo(o2.getName()));
        cakes.stream()
                .filter(o -> o.getName().equals("Kids Cake") || o.getName().equals("Wedding Cake"))
                .sorted((o1, o2) -> Integer.compare(o1.getPieces(), o2.getPieces()))
                .forEach(c -> System.out.println(c.getName() +  " for : " + c.getPrice() + " pieces - " + c.getPieces()));
        cakes.stream()
                .filter(o -> o.getName().equals("Special Cake") || o.getName().equals("Standart Cake"))
                .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                .forEach(c -> System.out.println(c.getName() +  " for : " + c.getPrice() + " pieces - " + c.getPieces()));

    }

    public Set<Cake> getCurrCakes() {
       return  this.cakes;
    }

    public Cake getCake() {
        return this.cakes.iterator().next();
    }

    public void removeCake(Cake cakeCopy) {
        this.cakes.remove(cakeCopy);
    }

    public void deliversInfo() {

        List<Deliver> delivers = new ArrayList<>(this.delivers);
        delivers.stream()
                .sorted((o1, o2) -> Double.compare(o2.getTips(), o1.getTips()))
                .forEach(o -> System.out.println(o.getName() + " has : " + o.getTips() + " tips."));

    }
}
