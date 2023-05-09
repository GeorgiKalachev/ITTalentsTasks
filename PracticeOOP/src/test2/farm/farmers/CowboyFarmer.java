package test2.farm.farmers;

import test2.farm.animals.Cattle;
import test2.farm.animals.Sheep;
import test2.farm.services.BuyService;
import test2.farm.services.Service;

import java.util.Set;

public class CowboyFarmer extends Farmer{

    //baj .. koito i da e

    public CowboyFarmer(String name, String favouriteTea) {
        super(name, favouriteTea);
    }

    @Override
    public void takeCareOfRanch() {
        Set<Cattle> cattleSet = farm.getCattle();
        for(Cattle fa : cattleSet){
            fa.eat();
            int milk = fa.giveMilk();
            farm.addMilk(milk);
            if (fa instanceof Sheep) {
                int wool = ((Sheep) fa).giveWool();
                farm.addWool(wool);
            }
        }
    }

    @Override
    protected boolean execute(Service s) {
        BuyService buyService = (BuyService) s;
        String product = buyService.getProduct();
        int quantity = buyService.getQuantity();
        if(product.equals("milk")){
            if(farm.getAvailableMilk() < quantity){
                return false;
            }
            else{
                farm.sellMilk(quantity);
                profit += quantity*2;
            }
        }
        else
        if(product.equals("wool")){
            if(farm.getTotalWool() < quantity){
                return false;
            }
            else{
                farm.sellWool(quantity);
                profit += quantity*23;
            }
        }
        return true;
    }

















}
