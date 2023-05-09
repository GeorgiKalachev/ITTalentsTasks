package snowWhiteHomework;

import snowWhiteHomework.characters.Person;

import java.util.ArrayList;

public class Mirror {

    public static ArrayList<Person> persons = new ArrayList<>();

    private final Person owner;

    public Mirror(Person owner) {
        this.owner = owner;
    }

    public boolean tellingTheTruth() {
        int beautyScale = 0;
        int personIdx = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).isAlive() && persons.get(i).getBeautyScale() > owner.getBeautyScale()) {
                personIdx = i;
            }
        }
        if (persons.get(personIdx).equals(owner)) {
            System.out.println("You " + owner.getName() + " YOU are most Beauiful in the world.");
            return true;
        } else {
            System.out.println(persons.get(personIdx).getName() + " is the most beautiful person in the world !");
            return false;
        }
    }

}
