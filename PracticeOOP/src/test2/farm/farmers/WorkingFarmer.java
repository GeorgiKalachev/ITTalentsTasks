package test2.farm.farmers;

import test2.farm.animals.WorkingAnimal;
import test2.farm.services.PloughService;
import test2.farm.services.Service;

import java.util.Optional;

public class WorkingFarmer extends Farmer{

    //chicho

    public WorkingFarmer(String name, String favouriteTea) {
        super(name, favouriteTea);
    }

    @Override
    public void takeCareOfRanch() {
        for(WorkingAnimal wa : farm.getWorkingAnimals()){
            wa.takeCare();
        }
    }

    @Override
    protected boolean execute(Service s) {
        PloughService ploughService = (PloughService) s;
        int area = ploughService.getSquareKm();

        Optional<WorkingAnimal> notTired = farm.getWorkingAnimals()
                .stream()
                .filter(a -> !a.isTired())
                .findFirst();
        if(notTired.isPresent()){
            int profit = area*60;
            notTired.get().plough();
            farm.incrementPloughing();
            farm.addProfit(profit);
            this.profit += profit;
            return true;
        }
        return false;
    }
}
