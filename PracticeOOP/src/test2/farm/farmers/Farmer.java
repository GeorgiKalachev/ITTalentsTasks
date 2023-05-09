package test2.farm.farmers;

import test2.farm.Farm;
import test2.farm.services.Service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Farmer {

    public static Farm farm;
    private String name;
    private String favouriteTea;
    protected int profit = 0;

    private Set<Service> services = new LinkedHashSet();

    public Farmer(String name, String favouriteTea) {
        this.name = name;
        this.favouriteTea = favouriteTea;
    }

    public void startDay(){
        drinkTea();
        takeCareOfRanch();
    }

    public void acceptService(Service s) {
        this.services.add(s);
    }

    public abstract void takeCareOfRanch();

    private void drinkTea() {
        System.out.println(name + " drinks his favourite tea " + favouriteTea);
    }

    public void executeServices(){
        for(Iterator<Service> it = services.iterator(); it.hasNext();){
            Service s = it.next();
            System.out.println("EXECUTING " + s.getType() + " FROM " + getClass().getName());
            if(!execute(s)){
                System.out.println("REJECTING " + s.getType());
                farm.incrementRejectedServices();
                farm.addService(s);
            }
            it.remove();
        }
    }

    protected abstract boolean execute(Service s);

    public int getProfit() {
        return profit;
    }

    public String getName() {
        return name;
    }
}
