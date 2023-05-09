package test2.farm;

import test2.farm.animals.WorkingAnimal;
import test2.farm.farmers.CowboyFarmer;
import test2.farm.farmers.Farmer;
import test2.farm.farmers.PettingFarmer;
import test2.farm.farmers.WorkingFarmer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
//        //city -> address, letters
//        Map<String, Map<String, Integer>> map = new HashMap<>();

//        for(Map.Entry<String, Map<String, Integer>> e : map.entrySet()){
//            System.out.println(e.getKey());
//            for(Map.Entry<String, Integer> e1 : e.getValue().entrySet()){
//                System.out.println(e1.getKey() + " - " + e1.getValue());
//            }
//        }

//        map.entrySet().stream()
//            .forEach(e -> {
//                System.out.println(e.getKey());
//                e.getValue().entrySet().stream()
//                    .forEach( e1 -> {
//                        System.out.println(e1.getKey() + " - " + e1.getValue());
//                    });
//            });

//        /*
//            Sofia:
//                Mladost 2 -> 123
//                Drujba -> 23
//            VT:
//                Pishmana -> 32
//                Triugulnika -> 65
//
//         */


        Farm farm = new Farm("El Kraso");
        Villager.farm = farm;
        Farmer.farm = farm;
        CowboyFarmer cowboyFarmer = new CowboyFarmer(Util.getRandomName(), Util.getRandomTea());
        PettingFarmer pettingFarmer = new PettingFarmer(Util.getRandomName(), Util.getRandomTea());
        WorkingFarmer workingFarmer = new WorkingFarmer(Util.getRandomName(), Util.getRandomTea());

        farm.hire(cowboyFarmer);
        farm.hire(pettingFarmer);
        farm.hire(workingFarmer);

        for (int i = 0; i < 10; i++) {
            Villager villager = new Villager();
            villager.thinkOfAService();
            villager.askFarm();
        }

        for (int i = 0; i < 3; i++) {
            farm.startDay();
        }
        farm.displayStatistics();
    }
}
