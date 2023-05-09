package kidsGarden;

public class Car {

    private final String model;
    private String colour;
    private Person owner;

    public Car(String model, String colour) {
        if (isValidModel(model) && isValidColour(colour)) {
            this.model = model;
            this.colour = colour;
            System.out.printf("You made a %s %s \n",colour,model);
        }else {

            System.out.println("Moron, we made you an Orange Moskwich");
            this.model = "Moskwich";
            this.colour = "Orange";
        }
    }

    public String getModel() {
        return model;
    }
    public String getColour() {
        return colour;
    }
    public Person getOwner() {
        return owner;
    }

    public void setColour(String colour) {
        if (isValidColour(colour)) {
            this.colour = colour;
            System.out.printf("You paint your car to %s \n",colour);
        }
    }

    public void setOwner(Person owner) {
        this.owner = owner;
        System.out.println("You changed " + this.model + " owner to - " + owner.getName());
    }





    private boolean isValidModel(String mod){
        return switch (mod) {
            case "Mercedes", "BMW", "Opel", "Mazda", "VW", "Nissan", "Ford" -> true;
            default -> false;
        };
    }
    private boolean isValidColour(String mod){
        return switch (mod) {
            case "Red", "White", "Green", "Black", "Blue", "Yellow", "Pink" -> true;
            default -> false;
        };
    }
}
