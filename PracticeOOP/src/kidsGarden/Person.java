package kidsGarden;

import kidsGarden.Car;

public class Person {

    private final String name;
    private Car car;
    private double money;

    public Person (){
        this.name = "Kolio";
    }
    public Person(String name, Car car, double money) {
        this.name = name;
        this.car = car;
        car.setOwner(this);
        this.money = money > 0 ? money : 0;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public double getMoney() {
        return money;
    }
    public void pay(double money){
        this.money -= money;
    }
}
