package test2.farm.animals;

public class Horse extends WorkingAnimal{

    @Override
    public void takeCare() {
        System.out.println("comb me");
        super.takeCare();
    }
}
