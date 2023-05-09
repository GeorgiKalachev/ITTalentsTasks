package krasiCode.shtafeta;

import java.util.ArrayList;
import java.util.TreeSet;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        startRace(8, 4);
    }

    public static void startRace(int teams, int runners) throws InterruptedException {

        ArrayList<Team> list = new ArrayList<>();
        for (int i = 0; i < teams; i++) {
            Team t = new Team("Team " + (i+1), runners);
            list.add(t);
            t.startRace();
        }
        //wait for everyone to stop running
        //Thread.sleep(runners*700);
        for(Team t : list){
            t.waitToFinish();
        }
        //mnogo qko
        TreeSet<Team> ranking = new TreeSet<>(list);
        for(Team t : ranking) {
            System.out.println(t.getName() + " - " + t.getTotalTimeRunning());
        }
    }
}
