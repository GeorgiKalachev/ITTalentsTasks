package test2.farm.animals;

public abstract class Pet extends FarmAnimal{

    private String name;
    private String breed;

    public Pet(String name, String breed) {
        super(FarmAnimalType.PET);
        this.name = name;
        this.breed = breed;
    }

    public void pet(){
        System.out.println("mil mil");
    }

}
