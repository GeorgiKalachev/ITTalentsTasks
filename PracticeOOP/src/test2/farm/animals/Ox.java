package test2.farm.animals;

public class Ox extends WorkingAnimal{

    @Override
    public void takeCare() {
        System.out.println("Sprinkling water on me");
        super.takeCare();
    }
}
