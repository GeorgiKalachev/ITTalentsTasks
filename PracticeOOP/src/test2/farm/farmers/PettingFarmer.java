package test2.farm.farmers;

import test2.farm.animals.FarmAnimal;
import test2.farm.animals.Pet;
import test2.farm.services.PetService;
import test2.farm.services.Service;

public class PettingFarmer extends Farmer{

    public PettingFarmer(String name, String favouriteTea) {
        super(name, favouriteTea);
    }

    @Override
    public void takeCareOfRanch() {
        for(Pet pet : farm.getPets()){
            pet.pet();
        }
    }

    @Override
    protected boolean execute(Service s) {
        PetService petService = (PetService) s;
        String who = petService.getWho();
        int profit = 0;
        if(who.equals("cat")){
            profit = petService.getHowMany()*5;
        }
        else
        if(who.equals("dog")){
            profit = petService.getHowMany()*3;
        }
        farm.addProfit(profit);
        this.profit += profit;
        return true;
    }
}
