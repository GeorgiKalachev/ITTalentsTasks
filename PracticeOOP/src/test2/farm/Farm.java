package test2.farm;

import test2.farm.animals.*;
import test2.farm.farmers.CowboyFarmer;
import test2.farm.farmers.Farmer;
import test2.farm.farmers.PettingFarmer;
import test2.farm.farmers.WorkingFarmer;
import test2.farm.services.Service;

import java.util.*;

public class Farm {

    private String name;
    private int money = 0;

    private Set<Cattle> cattles = new HashSet<>();
    private Set<WorkingAnimal> workingAnimals = new HashSet<>();
    private Set<Pet> pets = new HashSet<>();

    private Stack<Service> services = new Stack<>();

    private CowboyFarmer cowboyFarmer;
    private PettingFarmer pettingFarmer;
    private WorkingFarmer workingFarmer;
    private int startedServices = 0;
    private int rejectedServices = 0;


    private int availableMilk = 0;
    private int soldMilk = 0;
    private int totalWool = 0;
    private int ploughing = 0;

    public Farm(String name){
        this.name = name;
        for (int i = 0; i < 15; i++) {
            this.cattles.add(new Sheep());
        }
        for (int i = 0; i < 10; i++) {
            this.cattles.add(new Cow());
        }
        for (int i = 0; i < 3; i++) {
            this.workingAnimals.add(new Horse());
            this.workingAnimals.add(new Ox());
        }
        for (int i = 0; i < 2; i++) {
            this.pets.add(new Cat("Cat " + i, "Breed " + i));
            this.pets.add(new Dog("Dog " + i, "Breed " + i));
        }
    }

    public void startDay(){
        cowboyFarmer.startDay();
        pettingFarmer.startDay();
        workingFarmer.startDay();
        distributeServices();
        cowboyFarmer.executeServices();
        pettingFarmer.executeServices();
        workingFarmer.executeServices();
    }

    private void distributeServices() {
        for (int i = 0; i < 3; i++) {
            Service service = services.pop();
            startedServices++;
            switch (service.getType()){
                case BUY -> cowboyFarmer.acceptService(service);
                case PET -> pettingFarmer.acceptService(service);
                case PLOUGH -> workingFarmer.acceptService(service);
                default -> System.out.println("Unknown service, this should never happen");
            }
        }
    }

    public void hire(CowboyFarmer cowboyFarmer) {
        this.cowboyFarmer = cowboyFarmer;
    }

    public void hire(PettingFarmer pettingFarmer) {
        this.pettingFarmer = pettingFarmer;
    }

    public void hire(WorkingFarmer workingFarmer) {
        this.workingFarmer = workingFarmer;
    }

    public Set<Cattle> getCattle() {
        return Collections.unmodifiableSet(cattles);
    }

    public Set<Pet> getPets() {
        return Collections.unmodifiableSet(pets);
    }

    public Set<WorkingAnimal> getWorkingAnimals() {
        return Collections.unmodifiableSet(workingAnimals);
    }

    public void addMilk(int milk) {
        this.availableMilk += milk;
    }

    public void addWool(int wool) {
        this.totalWool += wool;
    }

    public void addService(Service service) {
        this.services.push(service);
    }

    public int getAvailableMilk() {
        return availableMilk;
    }

    public int getTotalWool() {
        return totalWool;
    }

    public void sellMilk(int quantity){
        if(this.availableMilk >= quantity) {
            this.availableMilk -= quantity;
            this.money += quantity*2;
            this.soldMilk += quantity;
        }
    }

    public void sellWool(int quantity){
        if(this.totalWool >= quantity) {
            this.totalWool -= quantity;
            this.money += quantity*23;
        }
    }

    public void addProfit(int profit){
        this.money += profit;
    }

    public void displayStatistics(){
        stat1();
        stat2();
        stat3();
        stat4();
    }

    private void stat4() {
        System.out.println("STAT 4");
        double completed = startedServices - rejectedServices;
        System.out.println("Completed % = " + (completed / startedServices * 100));
    }

    private void stat3() {
        System.out.println("STAT 3");
        System.out.println("Ploughing = " + ploughing);
    }

    private void stat2() {
        System.out.println("STAT 2");
        List<Farmer> farmers = List.of(workingFarmer, pettingFarmer, cowboyFarmer);
        farmers.stream()
            .sorted((o1, o2) -> o2.getProfit() - o1.getProfit())
            .forEach(f -> System.out.println(f.getName() + " - " + f.getProfit()));
    }

    private void stat1() {
        System.out.println("STAT 1");
        System.out.println("Total milk = " + (this.availableMilk + this.soldMilk));
    }

    public void incrementPloughing() {
        this.ploughing++;
    }

    public void incrementRejectedServices() {
        this.rejectedServices++;
    }
}
