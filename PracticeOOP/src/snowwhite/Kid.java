package snowwhite;


import java.util.Random;

public class Kid {

    private String name;
    private String city;
    private boolean hasChimney;
    private boolean isNaughty;
    private Factory factory;
    private Letter letter;
    private int approvedPresents;

    public Kid(String name, String city, boolean isNaughty, Factory factory){
        this.city = city;
        this.name = name;
        this.isNaughty = isNaughty;
        this.hasChimney = new Random().nextBoolean();
        this.letter = new Letter(this, Util.getRandomInt(1, 10));
        this.factory = factory;
        this.factory.receiveLetter(letter);
    }

    public boolean isNaughty() {
        return isNaughty;
    }

    public void approvePresent(){
        this.approvedPresents++;
    }

    public int getApprovedPresents() {
        return approvedPresents;
    }

    public String getName() {
        return name;
    }
}
