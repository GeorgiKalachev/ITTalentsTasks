package snowwhite;

import snowwhite.presents.Present;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Letter {

    private Kid owner;
    private ArrayList<Present.PresentType> presents = new ArrayList();

    public Letter(Kid kid, int presents){
        this.owner = kid;
        for (int i = 0; i < presents; i++) {
            this.presents.add(Util.getRandomPresentType());
        }
    }

    public Kid getOwner() {
        return owner;
    }

    public List<Present.PresentType> getPresents() {
        return Collections.unmodifiableList(presents);
    }
}
