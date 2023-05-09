package snowWhiteHomework.places;

import snowWhiteHomework.characters.Dwarf;
import snowWhiteHomework.characters.Person;
import snowWhiteHomework.characters.Snowhite;

public class DwarfsHome extends Place {

    public DwarfsHome() {
        super("Dwarfs home");
    }

    @Override
    public void setUsers(Person person) {
        super.setUsers(person);
        if (!(person instanceof Dwarf)) {
            System.out.println("Dwarfes understand someone else is in their house !");
            if (person instanceof Snowhite) {
                System.out.println("Its snowwhite. She will do house work and we will let her in.");
                setTheOneDoingHouseWork(person);
            } else {
                System.out.println("GET OUT !");
                userLeave(person);
            }
        }
    }

    public void setTheOneDoingHouseWork(Person theOneDoingHouseWork) {
    }

    public void doingTheHouseWork() {


    }
}
