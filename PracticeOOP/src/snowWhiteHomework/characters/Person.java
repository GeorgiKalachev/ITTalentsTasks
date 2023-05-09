package snowWhiteHomework.characters;

import snowWhiteHomework.Mirror;
import snowWhiteHomework.places.Place;
import snowWhiteHomework.PoisonedApple;

public abstract class Person {

    private final String name;
    private int beautyScale;
    private int age;
    private boolean isAlive;
    private Place homePlace;
    private Person lovedOne;


    public Person(String name, int age, int beautyScale, Place place) {
        this.name = name;
        this.age = age;
        this.beautyScale = beautyScale;
        Mirror.persons.add(this);
        this.isAlive = true;
        this.homePlace = place;
        place.setUsers(this);
    }

    public void killed() {
        isAlive = false;
    }

    public void revive() {
        isAlive = true;
    }

    public void setBeautyScale(int beautyScale) {
        this.beautyScale = beautyScale;
    }

    public void eat(PoisonedApple apple) {
        killed();
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void growUp() {
        this.age++;
    }

    public int getAge() {
        return age;
    }

    public int getBeautyScale() {
        return beautyScale;
    }

    public String getName() {
        return name;
    }

    public Place getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(Place homePlace) {
        this.homePlace = homePlace;
    }

    protected void runningInForest() {
    }

    protected void fallingInLove(Person person) {
        System.out.println(getName() + " and " + person.getName() + " falled in love and Married.");
        this.lovedOne = person;
        person.lovedOne = this;
        person.setHomePlace(this.getHomePlace());
        System.out.println("They lived happily ever after. " +
                "Exept the Queen she died in envy and angry and become very ugly.");
    }
}
