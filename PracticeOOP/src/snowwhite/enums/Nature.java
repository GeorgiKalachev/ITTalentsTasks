package snowwhite.enums;

import java.util.ArrayList;

public class Nature {

    private ArrayList<Human> people = new ArrayList();

    public void addHuman(Human human){
        this.people.add(human);
    }

    private void notifyAllHumans(Event event){
        for (int i = 0; i < people.size(); i++) {
            people.get(i).react(event);
        }
    }

    public void flood(){
        System.out.println("Flood!");
        notifyAllHumans(Event.FLOOD);
    }

    public void fire(){
        System.out.println("Fire!");
        notifyAllHumans(Event.FIRE);
    }

    public void tornado(){
        System.out.println("Tornado!");
        notifyAllHumans(Event.TORNADO);
    }
}
