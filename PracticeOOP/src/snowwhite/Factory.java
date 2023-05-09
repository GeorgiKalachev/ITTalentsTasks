package snowwhite;

import snowwhite.presents.Present;

import java.util.*;

public class Factory {

    private String name;
    private String address;
    private int postCode;
    private int totalExpenses;
    private ArrayList<Letter> postBox = new ArrayList();
    private SnowWhite snowWhite;
    private ArrayList<Dwarf> dwarves = new ArrayList();
    private int rejectedKids;
    private ArrayList<String> uniqueColors = new ArrayList();
    private ArrayList<Present> storage = new ArrayList();

    public Factory(String name){
        this.name = name;
        this.address = "Sofia";
        this.postCode = 1000;
    }

    public void hireDwarf(Dwarf dwarf){
        this.dwarves.add(dwarf);
        dwarf.setFactory(this);
    }

    public void hireSnowWhite(SnowWhite snowWhite){
        this.snowWhite = snowWhite;
        this.snowWhite.setFactory(this);
    }

    public void receiveLetter(Letter letter) {
        this.postBox.add(letter);
    }

    public void addExpenses(double expense) {
        this.totalExpenses+=expense;
    }

    public void addToStorage(Present present){
        this.storage.add(present);
    }

    public List<Letter> getPostBox() {
        return Collections.unmodifiableList(postBox);
    }

    public Dwarf getRandomWorker() {
        return this.dwarves.get(new Random().nextInt(this.dwarves.size()));
    }

    public void addColor(String color){
        if(!this.uniqueColors.contains(color)){
            this.uniqueColors.add(color);
        }
    }

    public void rejectKid() {
        this.rejectedKids++;
    }

    public void report1() {
        System.out.println("--------------REPORT 1--------------");
        System.out.println("Total letters = " + this.postBox.size());
        double naughtyLetters = 0;
        for (int i = 0; i < this.postBox.size(); i++) {
            if(this.postBox.get(i).getOwner().isNaughty()){
                naughtyLetters++;
            }
        }
        double goodLetters = (this.postBox.size() - naughtyLetters);
        double result = naughtyLetters > goodLetters ? (goodLetters / naughtyLetters * 100) : (naughtyLetters / goodLetters * 100);
        System.out.println("Ratio good/naughty is " +  result);
    }

    public void report2() {
        System.out.println("--------------REPORT 2--------------");
        Kid luckiestKid = this.postBox.get(0).getOwner();
        for (int i = 1; i < this.postBox.size(); i++) {
            Kid kid = this.postBox.get(i).getOwner();
            if(luckiestKid.getApprovedPresents() < kid.getApprovedPresents()){
                luckiestKid = kid;
            }
        }
        System.out.println("Kid with most presents = " + luckiestKid.getName() + " with " + luckiestKid.getApprovedPresents() + " presents");
    }

    public void report3() {
        //TODO
    }

    public void report4() {
        System.out.println("--------------REPORT 4--------------");
        Dwarf bestDwarf = this.dwarves.get(0);
        for (int i = 1; i < this.dwarves.size(); i++) {
            Dwarf dwarf = this.dwarves.get(i);
            if(bestDwarf.getPresentsCreated() < dwarf.getPresentsCreated()){
                bestDwarf = dwarf;
            }
        }
        System.out.println("Best dwarf is " + bestDwarf.getName() + " with " + bestDwarf.getPresentsCreated() + " presents");
    }

    public void report5() {
        System.out.println("--------------REPORT 5--------------");
        ArrayList<Dwarf> goodWorkers = new ArrayList<>();
        for (int i = 0; i < this.dwarves.size(); i++) {
            if(this.dwarves.get(i).getPresentsCreated() >= 10){
                goodWorkers.add(this.dwarves.get(i));
            }
        }
        Dwarf highest = null;
        for (int i = 0; i < goodWorkers.size(); i++) {
            if(highest == null || highest.getHeight() < goodWorkers.get(i).getHeight()){
                highest = goodWorkers.get(i);
            }
        }
        System.out.println("Highest good worker = " + (highest == null ? "none" : highest.getName()));
    }

    public void report7() {
        System.out.println("--------------REPORT 7--------------");
        System.out.println("Unique colors: " + this.uniqueColors.size());
    }

    public void report9() {
        System.out.println("--------------REPORT 9--------------");
        this.dwarves.sort((o1, o2) -> o2.getPresentsCreated() - o1.getPresentsCreated());
        for (int i = 0; i < this.dwarves.size(); i++) {
            System.out.println(this.dwarves.get(i).getName() + " - " + this.dwarves.get(i).getPresentsCreated());
        }
    }

    public void report11() {
        System.out.println("--------------REPORT 11--------------");
        System.out.println("Total expenses " + this.totalExpenses);
    }

    public void report13() {
        System.out.println("--------------REPORT 13--------------");
        System.out.println("Total rejected " + this.rejectedKids);
    }
}
