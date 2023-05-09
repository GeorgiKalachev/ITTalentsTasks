package kidsGarden;

import kidsGarden.Car;

import java.util.Random;

public class CarWash {

    private final String name;
    private final Car[] carFreeSpaces;
    private double priceOutWash;
    private double priceInnerWash;


    public CarWash(String name, double priceOutWash) {
        this.name = name;
        this.carFreeSpaces = new Car[5];
        this.priceOutWash = priceOutWash;
        this.priceInnerWash = this.priceOutWash * 1.5;
        System.out.println("You create a car wash with 5 free spaces. " +
                "Inner wash price is 50% more expensive than Outside wash.");
    }

    public String getName() {
        return name;
    }

    public Car[] getCarFreeSpaces() {
        return carFreeSpaces;
    }

    public double getPriceOutWash() {
        return priceOutWash;
    }

    public double getPriceInnerWash() {
        return priceInnerWash;
    }

    public void setPriceOutWash(double priceOutWash) {
        this.priceOutWash = priceOutWash;
        this.priceInnerWash = this.priceOutWash * 1.4;
        System.out.printf("You set the outwash to : %f , and inner wash is : %f",priceOutWash,priceInnerWash);
    }

    public double washingCar(Car car){
        int chance = new Random().nextInt(100);

        if (chance < 20){
            car.getOwner().pay(this.priceInnerWash);
            return this.priceInnerWash;
        }else if (chance < 50){
            car.getOwner().pay(this.priceOutWash);
            return this.priceOutWash;
        }else {
            car.getOwner().pay(this.priceInnerWash + this.priceOutWash);
            return this.priceInnerWash + this.priceOutWash;
        }
    }

    public void fillingWithCars(Car car1, Car car2, Car car3, Car car4, Car car5){
        carFreeSpaces[0] = car1;
        carFreeSpaces[1] = car2;
        carFreeSpaces[2] = car3;
        carFreeSpaces[3] = car4;
        carFreeSpaces[4] = car5;
    }
}
