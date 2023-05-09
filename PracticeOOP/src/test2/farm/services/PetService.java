package test2.farm.services;

public class PetService extends Service{

    private String who;
    private int howMany;

    public PetService(String who, int howMany) {
        this.who = who;
        this.howMany = howMany;
    }

    @Override
    public ServiceType getType() {
        return ServiceType.PET;
    }

    public String getWho() {
        return who;
    }

    public int getHowMany() {
        return howMany;
    }
}
