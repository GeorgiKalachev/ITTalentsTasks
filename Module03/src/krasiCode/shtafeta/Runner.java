package krasiCode.shtafeta;

import java.util.Random;

public class Runner extends Thread{

    private int number;
    private Runner previous;
    private String teamName;
    private Team team;

    public Runner(String teamName, Team team){
        this.teamName = teamName;
        this.team = team;
    }

    public void setPrevious(Runner previous) {
        this.previous = previous;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            if(previous != null) {
                previous.join();
            }
            System.out.println("Runner " + number + " From team " + teamName + " starts!");
            int lapTime = new Random().nextInt(200)+500;
            Thread.sleep(lapTime);
            team.addTime(lapTime);
            System.out.println("Runner " + number + " From team " + teamName + " finishes in " + lapTime);
        }
        catch (InterruptedException e){
            System.out.println("iha!");
        }
    }
}
