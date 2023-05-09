public class Main {
    public static void main(String[] args) {


        Computer computer1 = new Computer();
        System.out.println(" Comp1 - op system " + computer1.operationSystem);
        computer1.price = 1000;

        Computer comp2 = new Computer(1998, 1500, 4000, 2000);
        System.out.println("Comp2 year - " + comp2.year + " , op system " + comp2.operationSystem);

        Computer comp3 = new Computer(2022, 4500, true, 8000,
                4000, "Linux");
        System.out.println("Comp3 year " + comp3.year + ", op system - " + comp3.operationSystem +
                ", is Notebook - " + comp3.isNotebook);


        Computer comp4 = new Computer(2015, 1000, 2000, 1000);

        compare(computer1, comp4);
        compare(comp2, comp4);
        compare(comp2, comp3);
        compare(comp3, comp4);
        compare(comp3, computer1);
    }

    static void compare(Computer comp1, Computer comp2) {
        if (comp1.comparePrice(comp2) == 0) {
            System.out.println("Comp equals comp1");
            System.out.println("Price = " + comp1.price);
        }
        if (comp1.comparePrice(comp2) > 0) {
            System.out.println("Second computer is higher price. ");
            System.out.println("First comp price " + comp1.price + " < " +
                    comp2.price + " price comp2");
        }
        if (comp1.comparePrice(comp2) < 0) {
            System.out.println("First computer is higher price. > ");
            System.out.println("First comp price " + comp1.price + " > " +
                    comp2.price + " price comp2");
        }
    }
}