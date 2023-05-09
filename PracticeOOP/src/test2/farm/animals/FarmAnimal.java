package test2.farm.animals;

import java.util.Objects;

public abstract class FarmAnimal {

    private static int uniqueId = 1;
    private FarmAnimalType type;
    private int id;

    public FarmAnimal(FarmAnimalType type) {
        this.type = type;
        this.id = uniqueId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarmAnimal that = (FarmAnimal) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
