package Avtomivka.cars;

public abstract class Vehicles {


    private int id;
    private String name;

    public Vehicles(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
