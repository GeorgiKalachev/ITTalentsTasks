package krasiCode.shtafeta;

import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team> {

    private List<Runner> runners = new ArrayList<>();
    private String name;
    private int totalTimeRunning = 0;

    public Team(String name, int runners){
        this.name = name;
        for (int i = 0; i < runners; i++) {
            Runner r = new Runner(name, this);
            r.setNumber(i+1);
            if(i > 0){
                r.setPrevious(this.runners.get(i-1));
            }
            this.runners.add(r);
        }
    }

    public void startRace(){
        for(Runner r : runners){
            r.start();
        }
    }

    public void addTime(int lapTime) {
        this.totalTimeRunning += lapTime;
    }

    @Override
    public int compareTo(Team o) {
        if(totalTimeRunning == o.totalTimeRunning){
            return 1;
        }
        return totalTimeRunning - o.totalTimeRunning;
    }

    public String getName() {
        return name;
    }

    public int getTotalTimeRunning() {
        return totalTimeRunning;
    }

    public void waitToFinish() {
        try {
            runners.get(runners.size()-1).join();
        } catch (InterruptedException e) {
            System.out.println("lala");
        }
    }
}
