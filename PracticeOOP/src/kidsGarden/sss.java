package kidsGarden;

public class sss {
    public static void main(String[] args) {


        Car bmw = new Car("BMW", "Black");
        Car mergel = new Car("Mercedes", "White");
        Car opel = new Car("Opel", "Yellow");
        Car mazda = new Car("Mazda", "Red");
        Car vw = new Car("VW", "Blue");
        Car fak = new Car("Porshe", "Panamera");

        Person pesho = new Person("Peter", bmw, 100);
        Person gosho = new Person("Gergi", mergel, 100);
        Person sasho = new Person("Sasho", opel, 100);
        Person sisi = new Person("Sisi", mazda, 100);
        Person lili = new Person("Lili", vw, 100);
        Person dancho = new Person("Dancho", fak, 100);

        CarWash fiveMinutes = new CarWash("5mins", 10);
        System.out.println("name " + fiveMinutes.getName() + " inner price : " + fiveMinutes.getPriceInnerWash() +
                " Outer pricer : " + fiveMinutes.getPriceOutWash());

        System.out.println(fak.getOwner().getName() + " washed his " + fak.getModel() + " and cost him " +
                fiveMinutes.washingCar(fak));


        fiveMinutes.fillingWithCars(bmw, mergel, opel, mazda, vw);


        double carWashBalance = 0;
        double currCost = 0;
        Person highPayer = new Person();
        for (int i = 0; i < fiveMinutes.getCarFreeSpaces().length; i++) {
            double cost = fiveMinutes.washingCar(fiveMinutes.getCarFreeSpaces()[i]);
            carWashBalance += cost;
            if (cost > currCost) {
                currCost = cost;
                highPayer = fiveMinutes.getCarFreeSpaces()[i].getOwner();
            }
            System.out.println(fiveMinutes.getCarFreeSpaces()[i].getOwner().getName() + " washed his car for : " + cost);
        }
        System.out.println("kidsGarden.Car wash balance : " + carWashBalance);
        System.out.println("Highest payer is : " + highPayer.getName());

        System.out.println(highPayer.getName() + " left with " + highPayer.getMoney() + " money.");
    }
}