package snowWhiteHomework.places;

import snowWhiteHomework.characters.Person;

import java.util.ArrayList;

public abstract class Place {

    private final String name;
    private ArrayList<Person> users;

    public Place(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void setUsers(Person person) {
        this.users.add(person);
    }
    public void userLeave(Person person){
        this.users.remove(person);
    }

}
