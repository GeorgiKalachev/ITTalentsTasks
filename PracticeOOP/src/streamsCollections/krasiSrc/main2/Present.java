package main;


import java.util.Objects;

public class Present implements Comparable<Present>{

    private String name;
    private double price;
    private int id;
    private static int uniqueId = 1;

    public Present(String name, double price) {
        this.id = uniqueId++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return Double.compare(present.price, price) == 0 && Objects.equals(name, present.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Present o) {
//        //> 0 if this is greater than o -> this goes as right child
//        //< 0 if this is lesser than o -> this goes as left child
//        // 0 if both are equal -> this is not added to the collection
        if(this.name.compareTo(o.name) == 0){
            return Double.compare(this.price, o.price);
        }
        return this.name.compareTo(o.name);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}