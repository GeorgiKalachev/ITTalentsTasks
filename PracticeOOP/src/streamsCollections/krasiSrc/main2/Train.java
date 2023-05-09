package main;

import java.util.Objects;

public class Train extends Present{

    private String producer;

    public Train(String name, double price, String producer) {
        super(name, price);
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return Objects.equals(producer, train.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer);
    }
}
